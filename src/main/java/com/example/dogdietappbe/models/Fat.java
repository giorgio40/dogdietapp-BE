package com.example.dogdietappbe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "fats")
public class Fat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long fatid;

    private String fat;

    public Fat() {
    }
    private int number;

    public Fat(String fat) {
        this.fat = fat;
    }

    @OneToMany(mappedBy = "fat",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties(value = "fat",
            allowSetters = true)
    private Set<DogFat> dogs = new HashSet<>();



    public long getFatid() {
        return fatid;
    }

    public void setFatid(long fatid) {
        this.fatid = fatid;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public Set<DogFat> getDogs() {
        return dogs;
    }

    public void setDogs(Set<DogFat> fats) {
        this.dogs = fats;
    }
}
