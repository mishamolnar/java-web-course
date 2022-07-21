package com.example.springbootapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generic")
public class GenericController {

    @GetMapping
    public String hi() {
        return "adsfadsafds";
    }
}

