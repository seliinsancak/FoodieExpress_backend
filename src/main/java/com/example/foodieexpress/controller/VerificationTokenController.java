package com.example.foodieexpress.controller;

import com.example.foodieexpress.service.VerificationTokenService;
import com.example.foodieexpress.entity.VerificationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/verification")
public class VerificationTokenController {

    private final VerificationTokenService verificationTokenService;

    @Autowired
    public VerificationTokenController(VerificationTokenService verificationTokenService) {
        this.verificationTokenService = verificationTokenService;
    }

    // token ile kullanıcı doğrulaması
    @GetMapping("/verify/{token}")
    public ResponseEntity<String> verifyToken(@PathVariable String token) {
        Optional<VerificationToken> verificationToken = verificationTokenService.findByToken(token);

        if (verificationToken.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Token bulunamadı.");
        }

        if (verificationToken.get().isExpired()) {
            return ResponseEntity.status(HttpStatus.GONE).body("Token süresi dolmuş.");
        }

        // token geçerli, kullanıcı doğrulandı
        return ResponseEntity.ok("Kullanıcı doğrulandı.");
    }
}
