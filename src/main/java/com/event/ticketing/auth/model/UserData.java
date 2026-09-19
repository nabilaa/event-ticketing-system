package com.event.ticketing.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserModel {
    private String username;
    private String email;
    private UserRole role;
    private UserStatus status;
    private LocalDateTime createdAt;

    public UserModel() {
    }

    public UserModel(String username, String email, UserRole role, UserStatus status, LocalDateTime createdAt) {
        this.username = username;
        this.email = email;
        this.role = role;
        this.status = status;
        this.createdAt = createdAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
