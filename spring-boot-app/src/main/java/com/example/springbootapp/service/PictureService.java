package com.example.springbootapp.service;

import com.example.springbootapp.dto.PictureSubmissionRequest;
import com.example.springbootapp.dto.User;
import com.example.springbootapp.exceptions.DuplicateUserException;
import com.example.springbootapp.exceptions.IncorrectPictureUrlException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PictureService {
    private Map<String, User> users = new HashMap<>();
    private final NasaClientService nasaClientService;

    public void submit(PictureSubmissionRequest pictureSubmissionRequest) {
        if (users.containsKey(pictureSubmissionRequest.getRequest())) {
            throw new DuplicateUserException("same  user not acceptable");
        }
        var user = pictureSubmissionRequest.getPictureSubmission().getUser();
        var picture = pictureSubmissionRequest.getPictureSubmission().getPicture();
        if (picture.equals(nasaClientService.getLargestPicture())) {
            users.put(pictureSubmissionRequest.getRequest(), user);
        } else throw new IncorrectPictureUrlException("not correct url");
    }
 }
