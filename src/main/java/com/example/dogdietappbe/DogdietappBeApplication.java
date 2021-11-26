package com.example.dogdietappbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@PropertySource(value = "file:/Users/georg/georgeketodiet.properties",ignoreResourceNotFound = true)
public class DogdietappBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DogdietappBeApplication.class, args);
    }

}
