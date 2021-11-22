package com.example.dogdietappbe.controllers;

import com.example.dogdietappbe.models.User;
import com.example.dogdietappbe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("/users")
    public class UserController
    {
        /**
         * Using the User service to process user data
         */
        @Autowired
        private UserService userService;

        /**
         * Returns a list of all users
         * <br>Example: <a href="http://localhost:2019/users/users">http://localhost:2019/users/users</a>
         *
         * @return JSON list of all users with a status of OK
         * @see UserService#findAll() UserService.findAll()
         */
        @GetMapping(value = "/users",
                produces = "application/json")
        public ResponseEntity<?> listAllUsers()
        {
            List<User> myUsers = userService.findAll();
            return new ResponseEntity<>(myUsers,
                    HttpStatus.OK);
        }

        /**
         * Returns a single user based off a user id number
         * <br>Example: http://localhost:2019/users/user/7
         *
         * @param userId The primary key of the user you seek
         * @return JSON object of the user you seek
         * @see UserService#findUserById(long) UserService.findUserById(long)
         */
        @GetMapping(value = "/user/{userId}",
                produces = "application/json")
        public ResponseEntity<?> getUserById(
                @PathVariable
                        Long userId)
        {
            User u = userService.findUserById(userId);
            return new ResponseEntity<>(u,
                    HttpStatus.OK);
        }

        /**
         * Return a user object based on a given username
         * <br>Example: <a href="http://localhost:2019/users/user/name/cinnamon">http://localhost:2019/users/user/name/cinnamon</a>
         *
         * @param userName the name of user (String) you seek
         * @return JSON object of the user you seek
         * @see UserService#findByName(String) UserService.findByName(String)
         */
        @GetMapping(value = "/user/name/{userName}",
                produces = "application/json")
        public ResponseEntity<?> getUserByName(
                @PathVariable
                        String userName)
        {
            User u = userService.findByName(userName);
            return new ResponseEntity<>(u,
                    HttpStatus.OK);
        }


    }




