package com.example.dogdietappbe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name="minerals")
public class Mineral {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long mineralid;

    private String calcium;

    private String phosphorous;

    private String k;

    private String na;

    private String mg;

    private String cl;

    private String fe;

    private String  cu;

    private String  mn;

    private String zn;

    private String  i;

    private String Se;

    public Mineral() {
    }

    public Mineral(String calcium, String phosphorous, String k, String na, String mg, String cl, String fe, String cu, String mn, String zn, String i, String se) {
        this.calcium = calcium;
        this.phosphorous = phosphorous;
        this.k = k;
        this.na = na;
        this.mg = mg;
        this.cl = cl;
        this.fe = fe;
        this.cu = cu;
        this.mn = mn;
        this.zn = zn;
        this.i = i;
        Se = se;
    }

    @ManyToMany(mappedBy = "minerals")
    @JsonIgnoreProperties(value = "minerals", allowSetters = true)
    private Set<Dog> dogs = new HashSet<>();






    public long getMineralid() {
        return mineralid;
    }

    public void setMineralid(long mineralid) {
        this.mineralid = mineralid;
    }

    public String getCalcium() {
        return calcium;
    }

    public void setCalcium(String calcium) {
        this.calcium = calcium;
    }

    public String getPhosphorous() {
        return phosphorous;
    }

    public void setPhosphorous(String phosphorous) {
        this.phosphorous = phosphorous;
    }

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getNa() {
        return na;
    }

    public void setNa(String na) {
        this.na = na;
    }

    public String getMg() {
        return mg;
    }

    public void setMg(String mg) {
        this.mg = mg;
    }

    public String getCl() {
        return cl;
    }

    public void setCl(String cl) {
        this.cl = cl;
    }

    public String getFe() {
        return fe;
    }

    public void setFe(String fe) {
        this.fe = fe;
    }

    public String getCu() {
        return cu;
    }

    public void setCu(String cu) {
        this.cu = cu;
    }

    public String getMn() {
        return mn;
    }

    public void setMn(String mn) {
        this.mn = mn;
    }

    public String getZn() {
        return zn;
    }

    public void setZn(String zn) {
        this.zn = zn;
    }

    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i = i;
    }

    public String getSe() {
        return Se;
    }

    public void setSe(String se) {
        Se = se;
    }

    public Set<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(Set<Dog> dogs) {
        this.dogs = dogs;
    }
}
