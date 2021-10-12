package com.example.dogdietappbe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "supplements")

public class Supplement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String supplementid;

    private String supplement1;

    private String supplement2;

    private String supplement3;

    private String supplement4;

    private String supplement5;

    private String supplement6;

    private String supplement7;

    private String supplement8;

    private String supplement9;

    @ManyToMany(mappedBy = "supplements")
    @JsonIgnoreProperties(value = "supplementss", allowSetters = true)
    private Set<Dog> dogs = new HashSet<>();



    public Supplement() {
    }


    public Supplement(String supplement1, String supplement2, String supplement3, String supplement4, String supplement5, String supplement6, String supplement7, String supplement8, String supplement9) {
        this.supplement1 = supplement1;
        this.supplement2 = supplement2;
        this.supplement3 = supplement3;
        this.supplement4 = supplement4;
        this.supplement5 = supplement5;
        this.supplement6 = supplement6;
        this.supplement7 = supplement7;
        this.supplement8 = supplement8;
        this.supplement9 = supplement9;
    }

    public String getSupplementid() {
        return supplementid;
    }

    public void setSupplementid(String supplementid) {
        this.supplementid = supplementid;
    }

    public String getSupplement1() {
        return supplement1;
    }

    public void setSupplement1(String supplement1) {
        this.supplement1 = supplement1;
    }

    public String getSupplement2() {
        return supplement2;
    }

    public void setSupplement2(String supplement2) {
        this.supplement2 = supplement2;
    }

    public String getSupplement3() {
        return supplement3;
    }

    public void setSupplement3(String supplement3) {
        this.supplement3 = supplement3;
    }

    public String getSupplement4() {
        return supplement4;
    }

    public void setSupplement4(String supplement4) {
        this.supplement4 = supplement4;
    }

    public String getSupplement5() {
        return supplement5;
    }

    public void setSupplement5(String supplement5) {
        this.supplement5 = supplement5;
    }

    public String getSupplement6() {
        return supplement6;
    }

    public void setSupplement6(String supplement6) {
        this.supplement6 = supplement6;
    }

    public String getSupplement7() {
        return supplement7;
    }

    public void setSupplement7(String supplement7) {
        this.supplement7 = supplement7;
    }

    public String getSupplement8() {
        return supplement8;
    }

    public void setSupplement8(String supplement8) {
        this.supplement8 = supplement8;
    }

    public String getSupplement9() {
        return supplement9;
    }

    public void setSupplement9(String supplement9) {
        this.supplement9 = supplement9;
    }

    public Set<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(Set<Dog> dogs) {
        this.dogs = dogs;
    }
}
