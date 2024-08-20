package com.banking.userservice.service;

import com.banking.userservice.model.User;
import com.banking.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public User createUser(User user) {
        User savedUser = userRepository.save(user);
        kafkaTemplate.send("user-created", savedUser.getEmail());
        return savedUser;
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}