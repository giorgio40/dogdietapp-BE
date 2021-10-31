package com.example.dogdietappbe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="dogfat")
@IdClass(DogFatId.class)
public class DogFat implements Serializable {


    @Id
    @ManyToOne
    @JoinColumn(name = "fatid")
    @JsonIgnoreProperties(value="dogs",allowSetters = true)
    private Fat fat;

    @Id
    @ManyToOne
    @JoinColumn(name = "dogid")
    @JsonIgnoreProperties(value="dogs",allowSetters = true)
    private Dog dog;

    public DogFat() {
    }

    public DogFat(Fat fat, Dog dog) {
        this.fat = fat;
        this.dog = dog;
    }

    public Fat getFat() {
        return fat;

    }

    public void setFat(Fat fat) {
        this.fat = fat;
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
        if (!(o instanceof DogFat))
        {
            return false;
        }
        DogFat that = (DogFat) o;

        return ((dog == null) ? 0 : dog.getDogid()) == ((that.dog == null) ? 0 : that.dog.getDogid()) &&
                ((fat == null) ? 0 : fat.getFatid()) == ((that.fat == null) ? 0 : that.fat.getFatid());
    }

    @Override
    public int hashCode()
    {
        return 37;
    }
}
