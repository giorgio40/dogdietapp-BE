package com.example.dogdietappbe.models;

import java.io.Serializable;

public class DogSupplementId implements Serializable {

    private long dog;

    private long supplement;


    public DogSupplementId() {
    }

    public long getDog() {
        return dog;
    }

    public void setDog(long dog) {
        this.dog = dog;
    }

    public long getSupplement() {
        return supplement;
    }

    public void setSupplement(long supplement) {
        this.supplement = supplement;
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
        DogSupplementId that = (DogSupplementId)  o;

        return dog == that.dog &&
                supplement == that.supplement;
    }
}
