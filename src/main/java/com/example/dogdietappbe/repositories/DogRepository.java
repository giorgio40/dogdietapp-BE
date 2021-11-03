package com.example.dogdietappbe.repositories;

import com.example.dogdietappbe.models.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository <Dog,Long> {

    Dog findDogByWeight(String weight);
}
