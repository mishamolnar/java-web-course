package com.bobocode.intro;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Playground {

    //192.168.0.1   / 101
    @SneakyThrows
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8999)) {
            while (true) {
                try (Socket client = serverSocket.accept()) {
                    var reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    var line = reader.readLine();
                    System.out.println(client.getInetAddress().getHostAddress());
                    System.out.println(line);
                } catch (Exception e) {
                    System.out.println(e.toString());
                }

            }
        }
    }
}
