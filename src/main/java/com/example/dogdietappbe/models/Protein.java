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





    @OneToMany(mappedBy = "protein",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties(value = "protein",
           allowSetters = true)
    private Set<DogProteins> dogs = new HashSet<>();


    public Protein() {
    }

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

    public Set<DogProteins> getDogs() {
        return dogs;
    }

    public void setDogs(Set<DogProteins> proteins) {
        this.dogs = proteins;
    }
}


