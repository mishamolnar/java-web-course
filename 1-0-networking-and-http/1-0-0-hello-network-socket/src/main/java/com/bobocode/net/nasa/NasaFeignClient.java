package com.bobocode.net.nasa;


import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NasaFeignClient {

    public static void main(String[] args) {
        NasaFeignClient nasaFeignClient = new NasaFeignClient();
        String response = nasaFeignClient.getAllImages();
        List<String> ulrs = nasaFeignClient.parse(response);
        int max = 0;
        String biggestImage = "";
        for (String ulr : ulrs) {
            int size = nasaFeignClient.getImageSize(ulr);
            System.out.println(size);
            if (size > max) biggestImage = ulr;
            max = Math.max(size, max);
        }
        System.out.println("BIGGGGGGGGGEST");
        System.out.println(biggestImage);
        System.out.println(max);
    }

    @SneakyThrows
    private String getAllImages() {
        URL obj = new URL("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=10&api_key=DEMO_KEY");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } else {
            System.out.println("GET request not worked");
        }
        return "";
    }

    @SneakyThrows
    private int getImageSize(String url) {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            String num = con.getHeaderField("Content-Length");
            return Integer.parseInt(num);
        } else {
            System.out.println("GET request not worked");
        }
        return 0;
    }

    private List<String> parse(String response) {
        return Arrays.stream(response.split("\\\""))
                .filter(a -> a.contains("http"))
                .map(a -> a.replace(".jpl", ""))
                .collect(Collectors.toList());
    }
}
