package com.event.ticketbooking.auth.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.stereotype.Service;

import com.event.ticketbooking.auth.entity.User;
import com.event.ticketbooking.auth.model.AuthResponse;
import com.event.ticketbooking.auth.model.LoginRequest;
import com.event.ticketbooking.auth.model.RegisterRequest;
import com.event.ticketbooking.auth.model.UserRole;
import com.event.ticketbooking.auth.model.UserStatus;
import com.event.ticketbooking.common.security.JwtService;

import jakarta.transaction.Transactional;

@Service
public class AuthService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserService userService, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(RegisterRequest request) {
        if (userService.findByUsername(request.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username is already taken.");
        }

        String hashedPassword = passwordEncoder.encode(request.getPassword());

        User newUser = new User(request.getEmail(), request.getUsername(), hashedPassword, null, null, UserRole.CUSTOMER, UserStatus.ACTIVE, LocalDateTime.now());
        userService.save(newUser);

        return newUser;
    }
 
    @Transactional
    public AuthResponse login(LoginRequest request) {
        User user = userService.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password."));
        
        if (!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
            throw new IllegalArgumentException("Invalid email or password.");
        }

        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("role", user.getRole());

        String jwtToken = jwtService.generateToken(user.getUsername(), extraClaims);
        return new AuthResponse(jwtToken, "jwt", null, null);
    }
}
