package com.example.dogdietappbe.repositories;

import com.example.dogdietappbe.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String toLowerCase);
}
