package com.example.dogdietappbe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="dogsupplements")
@IdClass(DogSupplementId.class)
public class DogSupplements implements Serializable {


    @Id
    @ManyToOne
    @JoinColumn(name = "supplementid")
    @JsonIgnoreProperties(value = "dogs",
            allowSetters = true)
    private Supplement supplement;


    @Id
    @ManyToOne
    @JoinColumn(name = "dogid")
    @JsonIgnoreProperties(value = "supplements",
            allowSetters = true)
    private Dog dog;

    private int amount;

    public DogSupplements() {
    }

    public DogSupplements(Supplement supplement, Dog dog, int amount) {
        this.supplement = supplement;
        this.dog = dog;
        this.amount = amount;
    }

    public Supplement getSupplement() {
        return supplement;
    }

    public void setSupplement(Supplement supplement) {
        this.supplement = supplement;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof DogSupplements))
        {
            return false;
        }
          DogSupplements that = (DogSupplements) o;

        return ((dog == null) ? 0 : dog.getDogid()) == ((that.dog == null) ? 0 : that.dog.getDogid()) &&
                ((supplement == null) ? 0 : supplement.getSupplementId()) == ((that.supplement == null) ? 0 : that.supplement.getSupplementId());
    }

    @Override
    public int hashCode()
    {
        return 37;
    }
}










