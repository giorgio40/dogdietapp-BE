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

    public DogSupplements() {
    }

    public DogSupplements(Supplement supplement, Dog dog) {
        this.supplement = supplement;
        this.dog = dog;
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
                ((supplement == null) ? 0 : supplement.getSupplementid()) == ((that.supplement == null) ? 0 : that.supplement.getSupplementid());
    }

    @Override
    public int hashCode()
    {
        return 37;
    }
}










