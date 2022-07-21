package com.example.springbootapp.config;

import com.example.springbootapp.dto.ErrorResponse;
import com.example.springbootapp.exceptions.DuplicateUserException;
import com.example.springbootapp.exceptions.IncorrectPictureUrlException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PictureControllerAdvice {

    @ExceptionHandler(IncorrectPictureUrlException.class)
    public ResponseEntity<?> handleIncorrectPicture(IncorrectPictureUrlException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(DuplicateUserException.class)
    public ResponseEntity<?> handleDuplicateUser(DuplicateUserException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(e.getMessage()));
    }
}
