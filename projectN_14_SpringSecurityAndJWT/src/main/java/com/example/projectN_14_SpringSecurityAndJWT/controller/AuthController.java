package com.example.projectN_14_SpringSecurityAndJWT.controller;

import com.example.projectN_14_SpringSecurityAndJWT.dto.AuthRequest;
import com.example.projectN_14_SpringSecurityAndJWT.dto.AuthResponse;
import com.example.projectN_14_SpringSecurityAndJWT.dto.RegisterRequest;
import com.example.projectN_14_SpringSecurityAndJWT.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        authService.register(request);
        return ResponseEntity.ok("User registered successfully.");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}

