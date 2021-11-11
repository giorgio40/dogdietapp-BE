package com.example.dogdietappbe.controllers;

import com.example.dogdietappbe.models.Dog;
import com.example.dogdietappbe.services.DogServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/dogs")
public class DogController {

    @Autowired
    private DogServices dogServices;


    @GetMapping(value = "/dog/{dogId}",
            produces = "application/json")
    public ResponseEntity<?> getDogById(
            @PathVariable
                    Long dogId) {
        Dog d = dogServices.findDogById(dogId);
        return new ResponseEntity<>(d,
                HttpStatus.OK);


    }

}