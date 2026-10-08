package com.event.ticketbooking.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.ticketbooking.auth.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
    
    Optional<User> findByEmail(String email);

    void deleteByEmail(String email);

    Optional<User> findByUsername(String username);
}