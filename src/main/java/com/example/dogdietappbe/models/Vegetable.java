package com.example.dogdietappbe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "vegetables")
public class Vegetable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long vegetableid;

    private String vegetable;

    public Vegetable() {
    }

    public Vegetable(String vegetable) {
        this.vegetable = vegetable;
    }

    @OneToMany(mappedBy = "vegetable",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
   @JsonIgnoreProperties(value = "vegetable",
           allowSetters = true)
    private Set<DogVegetables> dogs = new HashSet<>();

    public long getVegetableid() {
        return vegetableid;
    }

    public void setVegetableid(long vegetableid) {
        this.vegetableid = vegetableid;
    }

    public String getVegetable() {
        return vegetable;
    }

    public void setVegetable(String vegetable) {
        this.vegetable = vegetable;
    }

    public Set<DogVegetables> getDogs() {
        return dogs;
    }

    public void setDogs(Set<DogVegetables> vegetables) {
        this.dogs = vegetables;
    }


}
