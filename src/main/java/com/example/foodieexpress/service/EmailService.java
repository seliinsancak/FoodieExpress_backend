package com.example.foodieexpress.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    public void sendEmail(String email, String verificationToken) {

    }

    public void sendResetPasswordEmail(String email, String token) {

    }
}