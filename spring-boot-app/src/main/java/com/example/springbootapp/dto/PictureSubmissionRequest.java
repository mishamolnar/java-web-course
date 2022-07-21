package com.example.springbootapp.dto;

import lombok.Data;

@Data
public class PictureSubmissionRequest {
    private final String request;
    private final PictureSubmission pictureSubmission;
}
