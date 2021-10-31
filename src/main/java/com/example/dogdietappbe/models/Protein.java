package com.example.dogdietappbe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name="proteins")
public class Protein {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long proteinid;


    private String protein;

    public Protein() {
    }

    @ManyToOne()
    @JsonIgnoreProperties(value = "proteins", allowSetters = true)
    private Dog dog;

    public Protein(String protein) {
        this.protein = protein;
    }

    public long getProteinid() {
        return proteinid;
    }

    public void setProteinid(long proteinid) {
        this.proteinid = proteinid;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
