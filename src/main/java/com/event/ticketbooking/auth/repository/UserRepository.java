package com.event.ticketbooking.auth.repository;

import com.event.ticketbooking.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}