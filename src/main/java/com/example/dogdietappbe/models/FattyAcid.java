package com.example.dogdietappbe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "fattyacids")
public class FattyAcid {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long fattyacidid;

    private String epa;

    private String dha;

    private String epadha;

    private String ala;

    @ManyToMany(mappedBy = "aminoacids")
    @JsonIgnoreProperties(value = "payments", allowSetters = true)
    private Set<Dog> dogs = new HashSet<>();


    public FattyAcid() {
    }

    public FattyAcid(String epa, String dha, String epadha, String ala) {
        this.epa = epa;
        this.dha = dha;
        this.epadha = epadha;
        this.ala = ala;
    }

    public long getFattyacidid() {
        return fattyacidid;
    }

    public void setFattyacidid(long fattyacidid) {
        this.fattyacidid = fattyacidid;
    }

    public String getEpa() {
        return epa;
    }

    public void setEpa(String epa) {
        this.epa = epa;
    }

    public String getDha() {
        return dha;
    }

    public void setDha(String dha) {
        this.dha = dha;
    }

    public String getEpadha() {
        return epadha;
    }

    public void setEpadha(String epadha) {
        this.epadha = epadha;
    }

    public String getAla() {
        return ala;
    }

    public void setAla(String ala) {
        this.ala = ala;
    }

    public Set<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(Set<Dog> dogs) {
        this.dogs = dogs;
    }
}
