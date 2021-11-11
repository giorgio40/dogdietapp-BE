package com.example.dogdietappbe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="dogproteins")
@IdClass(DogProteinId.class)
public class DogProteins implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "dogid")
    @JsonIgnoreProperties(value = "proteins", allowSetters = true)
    private Dog dog;

    @Id
    @ManyToOne
    @JoinColumn(name = "proteinid")
    @JsonIgnoreProperties(value = "dogs", allowSetters = true)
    private Protein protein;

    private  int amount;

    public DogProteins() {
    }

    public DogProteins(Dog dog, Protein protein, int amount) {
        this.dog = dog;
        this.protein = protein;
        this.amount = amount;
    }

    public int getAmount(){
        return amount;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public Protein getProtein() {
        return protein;
    }

    public void setProtein(Protein protein) {
        this.protein = protein;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof DogProteins))
        {
            return false;
        }
        DogProteins that = (DogProteins) o;
        return ((dog == null) ? 0 : dog.getDogid()) == ((that.dog == null) ? 0 : that.dog.getDogid()) &&
                ((protein == null) ? 0 : protein.getProteinid()) == ((that.protein == null) ? 0 : that.protein.getProteinid());
    }

    @Override
    public int hashCode()
    {
        return 37;
    }
}



