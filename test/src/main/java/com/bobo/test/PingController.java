package com.bobo.test;

import com.bobo.test.model.User;
import com.bobo.test.model.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ping")
public class PingController {
    private Map<String, User> users = new HashMap<>();

    @Autowired
    HttpServletRequest req;
    @Autowired
    UserHolder userHolder;

    @PostMapping
    public void ping(@RequestBody User user) {
        users.putIfAbsent(req.getRemoteAddr(), user);
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
