package com.example.dogdietappbe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name="dogs")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dogid;

    private String name;

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

    public Dog(String name, String weight, String calories) {
        this.name = name;
        this.weight = weight;
        this.calories = calories;
    }

    public long getDogid() {
        return dogid;
    }

    public void setDogid(long dogid) {
        this.dogid = dogid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<DogFat> getFats() {
        return fats;
    }

    public void setFats(Set<DogFat> fats) {
        this.fats = fats;
    }

    public Set<DogVegetables> getVegetables() {
        return vegetables;
    }

    public void setVegetables(Set<DogVegetables> vegetables) {
        this.vegetables = vegetables;
    }

    public Set<DogProteins> getProteins() {
        return proteins;
    }

    public void setProteins(Set<DogProteins> proteins) {
        this.proteins = proteins;
    }
}