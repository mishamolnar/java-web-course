package com.bobocode.servlet;

import lombok.SneakyThrows;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TestClient {

    @SneakyThrows
    public static void main(String[] args) {
        sendRerquest();

        sendRerquest();
    }

    private static void sendRerquest() throws IOException {
        try (Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 8080)) {
            PrintWriter wtr = new PrintWriter(socket.getOutputStream());


            wtr.println("GET /test?name=misha HTTP/1.1");
            wtr.println("Host: localhost");
            wtr.println("X-Mood: good");
            wtr.println("Cookie: JSESSIONID=E18E0EA3533A2BF40BC2A4515609F1B6");
            wtr.println("");
            wtr.flush();

            //Creates a BufferedReader that contains the server response
            BufferedReader bufRead = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String outStr;

            //Prints each line of the response
            while((outStr = bufRead.readLine()) != null){
                System.out.println(outStr);
            }


            //Closes out buffer and writer
            bufRead.close();
            wtr.close();
        }
    }
}
