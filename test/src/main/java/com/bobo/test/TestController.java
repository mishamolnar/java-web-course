package com.bobo.test;

import com.bobo.test.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/test")
public class TestController {
    private Map<String, User> users = new HashMap<>();

    @SneakyThrows
    @PostMapping
    public void ping(HttpServletRequest req, HttpServletResponse res) {
        var reader = req.getReader();
        var usrJsonStr = reader.lines().collect(Collectors.joining());
        var objectMapper = new ObjectMapper();
        var user = objectMapper.readValue(usrJsonStr, User.class);
        users.putIfAbsent(req.getRemoteAddr(), user);
    }

    @SneakyThrows
    @GetMapping
    public void getUsers(HttpServletRequest req, HttpServletResponse res) {
        var writer = res.getWriter();
        users.entrySet()
                .forEach(e -> System.out.println(e.getValue() + " " + e.getKey()));
        writer.flush();
    }
}
