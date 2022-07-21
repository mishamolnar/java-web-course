package com.example.springbootapp.controller;

import com.example.springbootapp.dto.PictureSubmission;
import com.example.springbootapp.dto.PictureSubmissionRequest;
import com.example.springbootapp.service.NasaClientService;
import com.example.springbootapp.service.PictureService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pictures")
public class PictureController {

    private final NasaClientService nasaClientService;
    private final PictureService pictureService;
    private final HttpServletRequest httpServletRequest;

    @PostMapping
    public void submit(@RequestBody PictureSubmission pictureSubmission) {
        var request = new PictureSubmissionRequest(httpServletRequest.getRemoteAddr(), pictureSubmission);
        pictureService.submit(request);
    }
}
