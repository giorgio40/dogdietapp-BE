package com.example.dogdietappbe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "supplements")
public class Supplement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long supplementid;

    private String supplement;





    @OneToMany(mappedBy = "supplement",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties(value = "supplement",
            allowSetters = true)
    private Set<DogSupplements> dogs = new HashSet<>();


    public Supplement() {
    }

    public Supplement(String supplement) {
        this.supplement = supplement;
    }

    public String getSupplement() {
        return supplement;
    }

    public void setSupplement(String supplement) {
        this.supplement = supplement;
    }
    

    public long getSupplementId() {
         return supplementid;
    }
}
