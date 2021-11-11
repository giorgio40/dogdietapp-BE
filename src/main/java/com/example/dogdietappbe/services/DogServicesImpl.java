package com.example.dogdietappbe.services;

import com.example.dogdietappbe.exceptions.ResourceNotFoundException;
import com.example.dogdietappbe.models.*;
import com.example.dogdietappbe.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Transactional
@Service(value = "dogservices")

public class DogServicesImpl implements DogServices {
    @Autowired
    private DogRepository dogrepos;

    @Autowired
    private SupplementRepository supprepos;

    @Autowired
    private ProteinRepository proteinrepos;

    @Autowired
    private FatRepository fatrepos;

    @Autowired
    private VegetableRepository vegrepos;

    @Override

    public Dog findDogById(long id) throws EntityNotFoundException {
        return dogrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dog " + id + " Not Found"));
    }

    @Override

    public Dog findDogByWeight(String weight) throws
            ResourceNotFoundException {
        Dog dog = dogrepos.findDogByWeight(weight);

        if (dog == null) {
            throw new ResourceNotFoundException("Dog " + weight + " not found!");
        }

        return dog;
    }

    @Transactional
    @Override
    public Dog save(Dog dog) {
        Dog newDog = new Dog();

        if (dog.getDogid() != 0) {
            dogrepos.findById(dog.getDogid())
                    .orElseThrow(() -> new ResourceNotFoundException("Dog id " + dog.getDogid() + " not found!"));
            newDog.setDogid(dog.getDogid());
        }

        newDog.setCalories(dog.getCalories());
        newDog.setWeight(dog.getWeight());


        newDog.getSupplements()
                .clear();
        for (DogSupplements ds : dog.getSupplements()) {
            Supplement newSupplement = supprepos.findById(ds.getSupplement().getSupplementId())
                    .orElseThrow(() -> new ResourceNotFoundException("Supplement id " + ds.getSupplement()
                            .getSupplementId() + " not found!"));

            newDog.getSupplements()
                    .add(new DogSupplements(newSupplement,
                            newDog,ds.getAmount()));
        }
            newDog.getProteins()
                    .clear();
            for (DogProteins d : dog.getProteins()) {
                Protein newProtein = proteinrepos.findById(d.getProtein().getProteinid())
                        .orElseThrow(() -> new ResourceNotFoundException("Protein id " + d.getProtein()
                                .getProteinid() + " not found!"));

                newDog.getProteins()
                        .add(new DogProteins(newDog,
                                newProtein,d.getAmount()));
            }
        for (DogFat d : dog.getFats()) {
            Fat newFat = fatrepos.findById(d.getFat().getFatid())
                    .orElseThrow(() -> new ResourceNotFoundException("Fat id " + d.getFat()
                            .getFatid() + " not found!"));

            newDog.getFats()
                    .add(new DogFat(newFat,newDog,d.getAmount()));

        }

        for (DogVegetables dv : dog.getVegetables()) {
            Vegetable newVeg = vegrepos.findById(dv.getVegetable().getVegetableid())
                    .orElseThrow(() -> new ResourceNotFoundException("Vegetable id " + dv.getVegetable()
                            .getVegetableid() + " not found!"));


            newDog.getVegetables()
                    .add(new DogVegetables(newVeg,
                            newDog, dv.getAmount()));

        }
        return dogrepos.save(newDog);
    }
}