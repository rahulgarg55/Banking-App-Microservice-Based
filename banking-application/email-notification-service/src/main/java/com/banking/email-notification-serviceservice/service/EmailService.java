package com.banking.emailnotificationservice.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @KafkaListener(topics = "user-created", groupId = "email-group")
    public void sendUserCreatedEmail(String email) {
        // In a real application, you would implement email sending logic here
        System.out.println("Sending user created email to: " + email);
    }

    @KafkaListener(topics = "account-created", groupId = "email-group")
    public void sendAccountCreatedEmail(String userId) {
        // In a real application, you would implement email sending logic here
        System.out.println("Sending account created email for user: " + userId);
    }
}