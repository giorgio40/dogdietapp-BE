package com.example.dogdietappbe.services;

import com.example.dogdietappbe.models.ValidationError;

import java.util.List;

public interface HelperFunctions {


    List <ValidationError> getConstraintViolation(Throwable cause);

    boolean isAuthroizedToMakeChange(String username);

    boolean isAuthorizedToMakeChange(String username);
}
