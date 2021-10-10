package com.example.dogdietappbe.services;

import com.example.dogdietappbe.models.Dog;
import com.example.dogdietappbe.repositories.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Transactional
@Service
public class DogServicesImpl implements DogServices{
    @Autowired
    private DogRepository dogrepos;
    @Override

        public Dog findDogById(long id) throws   EntityNotFoundException

        {
            return dogrepos.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Dog " + id + " Not Found"));
        }

    }

