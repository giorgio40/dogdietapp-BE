package com.example.dogdietappbe.models;

import java.io.Serializable;

public class DogFatId implements Serializable {

    private long dog;

    private long fat;


    public DogFatId() {
    }

    public long getDog() {
        return dog;
    }

    public void setDog(long dog) {
        this.dog = dog;
    }

    public long getFat() {
        return fat;
    }

    public void setFat(long fat) {
        this.fat = fat;
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
        DogFatId that = (DogFatId) o;
        return dog == that.dog &&
                fat == that.fat;
    }

    @Override
    public int hashCode()
    {
        return 37;
    }
}


