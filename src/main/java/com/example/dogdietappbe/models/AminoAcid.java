package com.example.dogdietappbe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name="aminoacids")
public class AminoAcid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long aminoacidid;

    private String histidine;

    private String arginine;

    private String isoleucine;

    private String leucine;

    private String lysine;

    private String methionione;

    private String phenaltyrosine;

    private String threonine;

    private String trypotophan;

    private String valine;

    private String methcystine;

    @ManyToMany(mappedBy = "aminoacids")
    @JsonIgnoreProperties(value = "aminoacids", allowSetters = true)
    private Set<Dog> dogs = new HashSet<>();





    public AminoAcid() {
    }

    public AminoAcid(String histidine, String arginine, String isoleucine, String leucine, String lysine, String methionione, String phenaltyrosine, String threonine, String trypotophan, String valine, String methcystine) {
        this.histidine = histidine;
        this.arginine = arginine;
        this.isoleucine = isoleucine;
        this.leucine = leucine;
        this.lysine = lysine;
        this.methionione = methionione;
        this.phenaltyrosine = phenaltyrosine;
        this.threonine = threonine;
        this.trypotophan = trypotophan;
        this.valine = valine;
        this.methcystine = methcystine;
    }

    public long getAminoacidid() {
        return aminoacidid;
    }

    public void setAminoacidid(long aminoacidid) {
        this.aminoacidid = aminoacidid;
    }

    public String getHistidine() {
        return histidine;
    }

    public void setHistidine(String histidine) {
        this.histidine = histidine;
    }

    public String getArginine() {
        return arginine;
    }

    public void setArginine(String arginine) {
        this.arginine = arginine;
    }

    public String getIsoleucine() {
        return isoleucine;
    }

    public void setIsoleucine(String isoleucine) {
        this.isoleucine = isoleucine;
    }

    public String getLeucine() {
        return leucine;
    }

    public void setLeucine(String leucine) {
        this.leucine = leucine;
    }

    public String getLysine() {
        return lysine;
    }

    public void setLysine(String lysine) {
        this.lysine = lysine;
    }

    public String getMethionione() {
        return methionione;
    }

    public void setMethionione(String methionione) {
        this.methionione = methionione;
    }

    public String getPhenaltyrosine() {
        return phenaltyrosine;
    }

    public void setPhenaltyrosine(String phenaltyrosine) {
        this.phenaltyrosine = phenaltyrosine;
    }

    public String getThreonine() {
        return threonine;
    }

    public void setThreonine(String threonine) {
        this.threonine = threonine;
    }

    public String getTrypotophan() {
        return trypotophan;
    }

    public void setTrypotophan(String trypotophan) {
        this.trypotophan = trypotophan;
    }

    public String getValine() {
        return valine;
    }

    public void setValine(String valine) {
        this.valine = valine;
    }

    public String getMethcystine() {
        return methcystine;
    }

    public void setMethcystine(String methcystine) {
        this.methcystine = methcystine;
    }
}

