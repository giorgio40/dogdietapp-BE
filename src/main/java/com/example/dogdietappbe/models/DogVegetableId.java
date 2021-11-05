package com.example.dogdietappbe.models;

import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class DogVegetableId implements Serializable {

    private long dog;

    private long vegetable;

    public DogVegetableId() {
    }

    public long getDog() {
        return dog;
    }

    public void setDog(long dog) {
        this.dog = dog;
    }

    public long getVegetable() {
        return vegetable;
    }

    public void setVegetable(long vegetable) {
        this.vegetable = vegetable;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        DogVegetableId that = (DogVegetableId)  o;

        return dog == that.dog &&
                vegetable== that.vegetable;
    }

    @Override
    public int hashCode() {
        return 37;
    }
}

