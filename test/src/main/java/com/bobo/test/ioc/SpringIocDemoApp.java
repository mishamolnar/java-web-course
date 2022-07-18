package com.bobo.test.ioc;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.client.RestTemplate;

public class SpringIocDemoApp {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext("com.bobo.test");
        var nasaClient = context.getBean(NasaPicturesClient.class);
        nasaClient.getAllPicturesUrls();
        var restTemplate = context.getBean(RestTemplate.class);
        var json = restTemplate.getForObject("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=10&api_key=DEMO_KEY", JsonNode.class);
        json.get("photos")
                .forEach(p -> System.out.println(p.get("img_src").asText()));
    }
}
