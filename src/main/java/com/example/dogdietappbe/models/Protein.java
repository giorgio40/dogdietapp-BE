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

    @ManyToMany(mappedBy = "proteins")
    @JsonIgnoreProperties(value = "proteins", allowSetters = true)
    private Set<Dog> dogs = new HashSet<>();

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
}
