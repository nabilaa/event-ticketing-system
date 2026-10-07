package com.event.ticketbooking.auth.entity;

import java.time.LocalDateTime;

import com.event.ticketbooking.auth.model.UserRole;
import com.event.ticketbooking.auth.model.UserStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    private String email;

    private String username;

    private String firstName;
    
    private String lastName;
    
    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.CUSTOMER;

    @Enumerated(EnumType.STRING)
    private UserStatus status = UserStatus.ACTIVE;

    private LocalDateTime createdAt;

    public User() {

    }

    public User(String email, String username, String firstName, String lastName, UserRole role, UserStatus status, LocalDateTime createdAt) {
        this.email = email;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.status = status;
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;    
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
