package com.example.dogdietappbe.exceptions;

public class ResourceNotFoundException
        extends RuntimeException
{
    public ResourceNotFoundException(String message)
    {
        super("Error from a Lambda School Application" + message);
    }
}