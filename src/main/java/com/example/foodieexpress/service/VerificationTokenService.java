package com.example.foodieexpress.service;

import com.example.foodieexpress.entity.VerificationToken;
import com.example.foodieexpress.repository.VerificationTokenRepository;
import com.example.foodieexpress.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class VerificationTokenService {

    private final VerificationTokenRepository verificationTokenRepository;

    @Autowired
    public VerificationTokenService(VerificationTokenRepository verificationTokenRepository) {
        this.verificationTokenRepository = verificationTokenRepository;
    }

    // token üretme
    public String generateVerificationToken(User user) {
        String token = UUID.randomUUID().toString(); // Benzersiz bir token oluştur
        LocalDateTime expiryDate = LocalDateTime.now().plusHours(1); // Token'in geçerlilik süresi (1 saat)

        VerificationToken verificationToken = new VerificationToken(null, token, user, expiryDate);
        verificationTokenRepository.save(verificationToken);
        return token;
    }

    // token ile doğrulama
    public Optional<VerificationToken> findByToken(String token) {
        return verificationTokenRepository.findByToken(token);
    }

    // token kaydetme
    public void save(VerificationToken token) {
        verificationTokenRepository.save(token);
    }
}
