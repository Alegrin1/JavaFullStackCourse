package com.example.projectN_14_SpringSecurityAndJWT.controller;

import com.example.projectN_14_SpringSecurityAndJWT.dto.RegisterRequest;
import com.example.projectN_14_SpringSecurityAndJWT.entity.User;
import com.example.projectN_14_SpringSecurityAndJWT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/me")
    public ResponseEntity<User> getMyProfile(Authentication auth) {
        String username = auth.getName();
        return ResponseEntity.ok(userRepo.findByUsername(username).orElseThrow());
    }

    @PutMapping("/me")
    public ResponseEntity<?> updateMyProfile(Authentication auth, @RequestBody RegisterRequest update) {
        User user = userRepo.findByUsername(auth.getName()).orElseThrow();
        user.setPassword(update.password()); // You may want to encode this
        userRepo.save(user);
        return ResponseEntity.ok("Updated.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userRepo.deleteById(id);
        return ResponseEntity.ok("Deleted.");
    }
}

