package com.event.ticketing.auth.repository;

import com.event.ticketing.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}