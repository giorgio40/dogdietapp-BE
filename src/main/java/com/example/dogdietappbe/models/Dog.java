package com.example.dogdietappbe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Table(name="dogs")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long dogid;

    private String weight;

    private String calories;


    @ManyToMany()
    @JoinTable(name = "dogfats",
            joinColumns = @JoinColumn(name = "dogid"),
            inverseJoinColumns = @JoinColumn(name = "fatid"))
    @JsonIgnoreProperties(value = "dog", allowSetters = true)
    Set<Fat> fats = new HashSet<>();

    @ManyToMany()
    @JoinTable(name = "dogproteins",
            joinColumns = @JoinColumn(name = "dogid"),
            inverseJoinColumns = @JoinColumn(name = "proteinid"))
    @JsonIgnoreProperties(value = "dogs", allowSetters = true)
    Set<Protein> proteins = new HashSet<>();

    @ManyToMany()
    @JoinTable(name = "dogvegetables",
            joinColumns = @JoinColumn(name = "dogid"),
            inverseJoinColumns = @JoinColumn(name = "vegetableid"))
    @JsonIgnoreProperties(value = "dogs", allowSetters = true)
    Set<Vegetable> vegetables = new HashSet<>();


    @ManyToMany()
    @JoinTable(name = "dogsupplements",
            joinColumns = @JoinColumn(name = "dogid"),
            inverseJoinColumns = @JoinColumn(name ="supplementid"))
    @JsonIgnoreProperties(value = "dogs", allowSetters = true)
    Set<Supplement> supplements = new HashSet<>();



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

    public Set<Fat> getFats() {
        return fats;
    }

    public void setFats(Set<Fat> fats) {
        this.fats = fats;
    }

    public Set<Protein> getProteins() {
        return proteins;
    }

    public void setProteins(Set<Protein> proteins) {
        this.proteins = proteins;
    }

    public Set<Vegetable> getVegetables() {
        return vegetables;
    }

    public void setVegetables(Set<Vegetable> vegetables) {
        this.vegetables = vegetables;
    }

    public Set<Supplement> getSupplements(Supplement s1) {
        return supplements;
    }

    public void setSupplements(Set<Supplement> supplements) {
        this.supplements = supplements;
    }
}