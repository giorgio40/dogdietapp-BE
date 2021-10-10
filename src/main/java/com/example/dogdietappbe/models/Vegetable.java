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

    @ManyToMany(mappedBy = "vegetables")
    @JsonIgnoreProperties(value = "payments", allowSetters = true)
    private Set<Dog> dogs = new HashSet<>();

    public Vegetable(String vegetable) {
        this.vegetable = vegetable;
    }

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

    public Set<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(Set<Dog> dogs) {
        this.dogs = dogs;
    }
}
