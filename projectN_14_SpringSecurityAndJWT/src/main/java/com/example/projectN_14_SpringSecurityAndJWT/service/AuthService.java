package com.example.projectN_14_SpringSecurityAndJWT.service;

import com.example.projectN_14_SpringSecurityAndJWT.dto.AuthRequest;
import com.example.projectN_14_SpringSecurityAndJWT.dto.AuthResponse;
import com.example.projectN_14_SpringSecurityAndJWT.dto.RegisterRequest;
import com.example.projectN_14_SpringSecurityAndJWT.entity.Role;
import com.example.projectN_14_SpringSecurityAndJWT.entity.User;
import com.example.projectN_14_SpringSecurityAndJWT.repository.UserRepository;
import com.example.projectN_14_SpringSecurityAndJWT.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepo;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private JwtUtil jwtUtil;
    @Autowired private AuthenticationManager authManager;

    public void register(RegisterRequest request) {
        var user = new User();
        user.setUsername(request.username());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setRole(Role.USER);
        userRepo.save(user);
    }

    public AuthResponse login(AuthRequest request) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );
        var user = userRepo.findByUsername(request.username()).orElseThrow();
        String token = jwtUtil.generateToken(user);
        return new AuthResponse(token);
    }
}
