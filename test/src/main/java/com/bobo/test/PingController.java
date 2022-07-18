package com.bobo.test;

import com.bobo.test.model.User;
import com.bobo.test.model.UserHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ping")
@RequiredArgsConstructor
public class PingController {
    private Map<String, User> users = new HashMap<>();


    private final UserHolder userHolder;
    private final HttpServletRequest httpServletRequest;

    @PostMapping
    public void ping(@RequestBody User user) {
        users.putIfAbsent("assdfasfd", user);
        if (userHolder.getCurrentUser() == null)
            userHolder.setCurrentUser(user);
    }

    @GetMapping
    public Collection<User> getUsers() {
        return users.values();
    }

    @GetMapping("/current")
    public User getCurrentUser() {
        return userHolder.getCurrentUser();
    }
}
