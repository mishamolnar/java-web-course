package com.example.springbootapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PictureSubmission {
    private User user;
    private Picture picture;
}
