package com.example.springbootapp.exceptions;

public class DuplicateUserException extends RuntimeException {
    public DuplicateUserException(String s) {
        super(s);
    }
}
