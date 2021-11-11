package com.example.dogdietappbe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "dogvegetables")
@IdClass(DogVegetableId.class)
public class DogVegetables implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "vegetableid")
    @JsonIgnoreProperties(value = "dogs", allowSetters = true)
    private Vegetable vegetable;

    @Id
    @ManyToOne
    @JoinColumn(name = "dogid")
    @JsonIgnoreProperties(value = "vegetables", allowSetters = true)
    private Dog dog;

    private int amount;

    public DogVegetables() {
    }

    public DogVegetables(Vegetable vegetable, Dog dog, int amount) {
        this.vegetable = vegetable;
        this.dog = dog;
        this.amount = amount;
    }

    public Vegetable getVegetable() {
        return vegetable;
    }

    public void setVegetable(Vegetable vegetable) {
        this.vegetable = vegetable;
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
        if (!(o instanceof DogVegetables))
        {
            return false;
        }
        DogVegetables that = (DogVegetables) o;
        return ((dog == null) ? 0 : dog.getDogid()) == ((that.dog == null) ? 0 : that.dog.getDogid()) &&
                ((vegetable == null) ? 0 : vegetable.getVegetableid()) == ((that.vegetable == null) ? 0 : that.vegetable.getVegetableid());
    }

    @Override
    public int hashCode()
    {
        return 37;
    }

}