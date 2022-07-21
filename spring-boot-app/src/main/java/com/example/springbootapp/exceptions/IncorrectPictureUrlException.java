package com.example.springbootapp.exceptions;

public class IncorrectPictureUrlException extends RuntimeException {
        public IncorrectPictureUrlException(String s) {
            super(s);
        }
    }