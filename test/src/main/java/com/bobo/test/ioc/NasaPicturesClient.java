package com.bobo.test.ioc;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class NasaPicturesClient {
    //"https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=10&api_key=DEMO_KEY"

    public List<String> getAllPicturesUrls() {
        System.out.println("Nasa call");
        return Collections.emptyList();
    }
}
