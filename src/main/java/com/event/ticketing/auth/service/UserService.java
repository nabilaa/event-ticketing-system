package com.event.ticketing.auth.service;

import com.event.ticketing.auth.repository.UserRepository;
import com.event.ticketing.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<User> findById(String email) {
        return userRepository.findById(email);
    }

    @Transactional
    public void deleteById(String email) {
        userRepository.deleteById(email);
    }
}