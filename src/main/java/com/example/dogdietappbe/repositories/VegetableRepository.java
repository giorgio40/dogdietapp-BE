package com.example.dogdietappbe.repositories;

import com.example.dogdietappbe.models.Vegetable;
import org.springframework.data.repository.CrudRepository;

public interface VegetableRepository extends CrudRepository<Vegetable,Long> {
}
