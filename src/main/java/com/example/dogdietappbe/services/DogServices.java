package com.example.dogdietappbe.services;

import com.example.dogdietappbe.models.Dog;

public interface DogServices {

    Dog findDogById(long id);

    Dog findDogByWeight(String weight);
}