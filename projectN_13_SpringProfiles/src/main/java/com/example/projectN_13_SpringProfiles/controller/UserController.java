package com.example.projectN_13_SpringProfiles.controller;

import com.example.projectN_13_SpringProfiles.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final Map<Long, User> users = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    public List<User> getAllUsers() {
        logger.info("Fetching all users");
        return new ArrayList<>(users.values());
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        long id = counter.incrementAndGet();
        user.setId(id);
        users.put(id, user);
        logger.info("User added: {}", user);
        return user;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        if (users.containsKey(id)) {
            users.remove(id);
            logger.info("User deleted with id: {}", id);
            return "User deleted.";
        } else {
            logger.warn("Attempted to delete non-existent user with id: {}", id);
            return "User not found.";
        }
    }
}