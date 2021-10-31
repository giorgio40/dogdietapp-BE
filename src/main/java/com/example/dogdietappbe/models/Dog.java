package com.example.dogdietappbe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name="dogs")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long dogid;

    private String weight;

    private String calories;

    @OneToMany(mappedBy = "dog",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties(value = "dog",
            allowSetters = true)
    private Set<DogSupplements> supplements = new HashSet<>();

    @OneToMany(mappedBy = "dog",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties(value = "dog",
            allowSetters = true)
    private Set<DogFat> fats = new HashSet<>();

    @OneToMany(mappedBy = "dog",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties(value = "dog",
            allowSetters = true)
    private Set<DogVegetables> vegetables = new HashSet<>();

    @OneToMany(mappedBy = "dog",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties(value = "dog",
            allowSetters = true)
    private Set<DogProteins> proteins = new HashSet<>();






    public Dog() {
    }

    public Dog(String weight, String calories) {
        this.weight = weight;
        this.calories = calories;
    }

    public long getDogid() {
        return dogid;
    }

    public void setDogid(long dogid) {
        this.dogid = dogid;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public Set<DogSupplements> getSupplements() {
        return supplements;
    }

    public void setSupplements(Set<DogSupplements> supplements) {
        this.supplements = supplements;
    }
}

