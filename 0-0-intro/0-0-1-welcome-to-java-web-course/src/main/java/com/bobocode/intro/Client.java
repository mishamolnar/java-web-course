package com.bobocode.intro;

import lombok.SneakyThrows;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    @SneakyThrows
    public static void main(String[] args) {
        try (var socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 8999)) {
            var writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write("adsfkasdjknd HELLLLLLOOOOO");
            writer.flush();
        }
    }
}
