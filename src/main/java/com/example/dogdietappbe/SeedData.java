package com.example.dogdietappbe;

import com.example.dogdietappbe.models.Dog;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.ManyToMany;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Transactional
@Component
public class SeedData implements CommandLineRunner {
    @Transactional
    @Override
    public void run(String[] args) throws
            Exception{














    }


}
