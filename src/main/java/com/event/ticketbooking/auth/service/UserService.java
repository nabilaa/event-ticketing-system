package com.event.ticketbooking.auth.service;

import com.event.ticketbooking.auth.entity.User;
import com.event.ticketbooking.auth.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(String email) {
        return userRepository.findById(email);
    }

    public void deleteById(String email) {
        userRepository.deleteById(email);
    }
}