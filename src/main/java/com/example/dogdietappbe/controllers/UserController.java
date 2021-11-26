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
public class UserController{

    @Autowired
    private UserService userService;

        @GetMapping(value = "/users", produces = "application/json")
    public ResponseEntity<?> getAllUsers()
    {
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

        /**
         * Gets user by username like.
         *
         * @param username the username
         * @return the user by username like
         */
        @GetMapping(value = "/username/like/{username}", produces = "application/json")
        public ResponseEntity<?> getUserByUsernameLike(@PathVariable String username)
        {
            List<User> users = userService.findUsersByUsernameLike(username);
            return new ResponseEntity<>(users, HttpStatus.OK);
        }

        /**
         * Gets user by id.
         *
         * @param userid the userid
         * @return the user by id
         */
        @GetMapping(value = "/user/{userid}", produces = "application/json")
        public ResponseEntity<?> getUserById(@PathVariable long userid)
        {
            User user = userService.findUserById(userid);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

