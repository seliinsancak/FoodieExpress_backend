package com.example.foodieexpress.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerificationTokenService {
    private final VerificationTokenRepository verificationTokenRepository;

    public String generateVerificationToken(Long userId) {

        return "generatedToken";
    }

    public Optional<VerificationToken> findByToken(String token) {
        return verificationTokenRepository.findByToken(token);
    }

    public void save(VerificationToken token) {
        verificationTokenRepository.save(token);
    }
}
