package com.example.dogdietappbe.services;

import com.example.dogdietappbe.models.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findUserById();

    User findByName();

    void delete(long id);

    User Save(User user);

    User update(User user, long id);


}
