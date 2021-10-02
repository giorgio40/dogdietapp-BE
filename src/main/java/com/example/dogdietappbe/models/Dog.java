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
    @JoinTable(name = "dogvitamins",
            joinColumns = @JoinColumn(name = "dogid"),
            inverseJoinColumns = @JoinColumn(name = "vitaminid"))
    @JsonIgnoreProperties(value = "dogs", allowSetters = true)
    Set<Vitamin> vitamins = new HashSet<>();

    @ManyToMany()
    @JoinTable(name = "dogminerals",
            joinColumns = @JoinColumn(name = "dogid"),
            inverseJoinColumns = @JoinColumn(name = "mineralid"))
    @JsonIgnoreProperties(value = "dogs", allowSetters = true)
    List<Mineral> minerals = new ArrayList<>();

    @ManyToMany()
    @JoinTable(name = "dogfattyacids",
            joinColumns = @JoinColumn(name = "dogid"),
            inverseJoinColumns = @JoinColumn(name = "fattyacidid"))
    @JsonIgnoreProperties(value = "dogs", allowSetters = true)
    List <FattyAcid> fattyAcid = new ArrayList<>();

    @ManyToMany()
    @JoinTable(name = "dogfats",
            joinColumns = @JoinColumn(name = "dogid"),
            inverseJoinColumns = @JoinColumn(name = "fatid"))
    @JsonIgnoreProperties(value = "restaurants", allowSetters = true)
    Set<Fat> fats = new HashSet<>();

    @ManyToMany()
    @JoinTable(name = "dogproteins",
            joinColumns = @JoinColumn(name = "dogid"),
            inverseJoinColumns = @JoinColumn(name = "proteinid"))
    @JsonIgnoreProperties(value = "restaurants", allowSetters = true)
    Set<Protein> proteins= new HashSet<>();

    @ManyToMany()
    @JoinTable(name = "dogvegetables",
            joinColumns = @JoinColumn(name = "dogid"),
            inverseJoinColumns = @JoinColumn(name = "vegetableidd"))
    @JsonIgnoreProperties(value = "restaurants", allowSetters = true)
    Set<Vegetable> vegetables= new HashSet<>();

    @ManyToMany()
    @JoinTable(name = "dogaminos",
            joinColumns = @JoinColumn(name = "dogid"),
            inverseJoinColumns = @JoinColumn(name = "aminod"))
    @JsonIgnoreProperties(value = "restaurants", allowSetters = true)
    Set<AminoAcid> aminoacid= new HashSet<>();



    @ManyToMany
    @JoinTable(name = "dogs_fattyacids",
            joinColumns = @JoinColumn(name = "dog_dogid", referencedColumnName = "fattyacids_fattyacidid"))
    private List<FattyAcid> fattyacids;

    @ManyToMany
    @JoinTable(name = "dogs_aminoacids",
            joinColumns = @JoinColumn(name = "dog_dogid", referencedColumnName = "aminoacids_aminoacidid"))
    private List<AminoAcid> aminoacids;

    public Dog() {
    }

    public Dog(String weight, String calories) {
        this.weight = weight;
        this.calories = calories;
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

    public Set<Vitamin> getVitamins() {
        return vitamins;
    }

    public void setVitamins(Set<Vitamin> vitamins) {
        this.vitamins = vitamins;
    }

    public List<Mineral> getMinerals() {
        return minerals;
    }

    public void setMinerals(List<Mineral> minerals) {
        this.minerals = minerals;
    }

    public List<FattyAcid> getFattyAcid() {
        return fattyAcid;
    }

    public void setFattyAcid(List<FattyAcid> fattyAcid) {
        this.fattyAcid = fattyAcid;
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

    public Set<AminoAcid> getAminoacid() {
        return aminoacid;
    }

    public void setAminoacid(Set<AminoAcid> aminoacid) {
        this.aminoacid = aminoacid;
    }

    public List<FattyAcid> getFattyacids() {
        return fattyacids;
    }

    public void setFattyacids(List<FattyAcid> fattyacids) {
        this.fattyacids = fattyacids;
    }

    public List<AminoAcid> getAminoacids() {
        return aminoacids;
    }

    public void setAminoacids(List<AminoAcid> aminoacids) {
        this.aminoacids = aminoacids;
    }

    public long getDogid() {
        return dogid;
    }

    public void setDogid(long dogid) {
        this.dogid = dogid;
    }
}
