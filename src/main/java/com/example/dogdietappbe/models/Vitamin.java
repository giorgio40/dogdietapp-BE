package com.example.dogdietappbe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "vitamins")
public class Vitamin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long vitaminid;


    private String vitaminA;

    private String vitaminD;

    private String vitaminE;

    private String riboflavin;

    private String b6;

    private String thiamine;

    private String pantothenicacid;

    private String  folicacid;

    private String choline;

    private String vitamink1;

    private String Biotin;

    @ManyToMany(mappedBy = "vitamins")
    @JsonIgnoreProperties(value = "payments", allowSetters = true)
    private Set<Dog> restaurants = new HashSet<>();



    public Vitamin() {
    }

    public Vitamin(String vitaminA, String vitaminD, String vitaminE, String riboflavin, String b6, String thiamine, String pantothenicacid, String folicacid, String choline, String vitamink1, String biotin) {
        this.vitaminA = vitaminA;
        this.vitaminD = vitaminD;
        this.vitaminE = vitaminE;
        this.riboflavin = riboflavin;
        this.b6 = b6;
        this.thiamine = thiamine;
        this.pantothenicacid = pantothenicacid;
        this.folicacid = folicacid;
        this.choline = choline;
        this.vitamink1 = vitamink1;
        Biotin = biotin;
    }

    public long getVitaminid() {
        return vitaminid;
    }

    public void setVitaminid(long vitaminid) {
        this.vitaminid = vitaminid;
    }

    public String getVitaminA() {
        return vitaminA;
    }

    public void setVitaminA(String vitaminA) {
        this.vitaminA = vitaminA;
    }

    public String getVitaminD() {
        return vitaminD;
    }

    public void setVitaminD(String vitaminD) {
        this.vitaminD = vitaminD;
    }

    public String getVitaminE() {
        return vitaminE;
    }

    public void setVitaminE(String vitaminE) {
        this.vitaminE = vitaminE;
    }

    public String getRiboflavin() {
        return riboflavin;
    }

    public void setRiboflavin(String riboflavin) {
        this.riboflavin = riboflavin;
    }

    public String getB6() {
        return b6;
    }

    public void setB6(String b6) {
        this.b6 = b6;
    }

    public String getThiamine() {
        return thiamine;
    }

    public void setThiamine(String thiamine) {
        this.thiamine = thiamine;
    }

    public String getPantothenicacid() {
        return pantothenicacid;
    }

    public void setPantothenicacid(String pantothenicacid) {
        this.pantothenicacid = pantothenicacid;
    }

    public String getFolicacid() {
        return folicacid;
    }

    public void setFolicacid(String folicacid) {
        this.folicacid = folicacid;
    }

    public String getCholine() {
        return choline;
    }

    public void setCholine(String choline) {
        this.choline = choline;
    }

    public String getVitamink1() {
        return vitamink1;
    }

    public void setVitamink1(String vitamink1) {
        this.vitamink1 = vitamink1;
    }

    public String getBiotin() {
        return Biotin;
    }

    public void setBiotin(String biotin) {
        Biotin = biotin;
    }
}
