package com.example.dogdietappbe.repositories;

import com.example.dogdietappbe.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String toLowerCase);



    List<User> findByUsernameContainingIgnoringCase(String username);
}

