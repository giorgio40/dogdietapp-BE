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

    public Fat(String fat) {
        this.fat = fat;
    }

    @ManyToMany(mappedBy = "fats")
    @JsonIgnoreProperties(value = "fats", allowSetters = true)
    private Set<Dog> dogs = new HashSet<>();



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

    public Set<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(Set<Dog> dogs) {
        this.dogs = dogs;
    }


}
