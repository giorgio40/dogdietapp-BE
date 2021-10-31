package com.example.dogdietappbe.models;

import java.io.Serializable;

public class DogProteinId implements Serializable {


    private long dog;

    private long protein;

    public DogProteinId() {
    }

    public long getDog() {
        return dog;
    }

    public void setDog(long dog) {
        this.dog = dog;
    }

    public long getProteins() {
        return protein;
    }

    public void setProteins(long protein) {
        this.protein = protein;
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
        DogProteinId that = (DogProteinId)  o;

        return dog == that.dog &&
                protein== that.protein;
    }

        @Override
        public int hashCode() {
            return 37;
    }
}
