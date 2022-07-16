package com.bobocode.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printData(req, resp);

    }

    @SneakyThrows
    private void printData(HttpServletRequest req, HttpServletResponse resp) {
        var session = req.getSession();
        var sessionName = Optional.ofNullable((String) session.getAttribute("name"));


        String mood = getClientsMood(req);
        var writer = resp.getWriter();
        var name = Optional.ofNullable(req.getParameter("name"))
                .orElse("Stranger");
        writer.println("GOOOOOG DAY, " + name);
        writer.println(mood);
        writer.println(sessionName.orElse("NO SESSION"));
        session.setAttribute("name", "MISHA");
    }


    private String getClientsMood(HttpServletRequest req) {
        return Optional.ofNullable(req.getHeader("X-Mood"))
                .orElse("No mood in header");
    }
}
