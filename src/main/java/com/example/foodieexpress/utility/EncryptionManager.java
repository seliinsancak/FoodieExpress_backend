package com.example.foodieexpress.utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Component
public class EncryptionManager {

    @Value("${encryption.secret-key}")
    private String secretKey;

    private static final String ALGORITHM = "AES";


    public String encrypt(String plainText) {
        try {
            SecretKey key = generateKey();
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Şifreleme işlemi sırasında bir hata oluştu.", e);
        }
    }


    public String decrypt(String encryptedText) {
        try {
            SecretKey key = generateKey();
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);

            byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);
            byte[] originalBytes = cipher.doFinal(decodedBytes);

            return new String(originalBytes);
        } catch (Exception e) {
            throw new RuntimeException("Şifre çözme işlemi sırasında bir hata oluştu.", e);
        }
    }


    private SecretKey generateKey() {
        try {
            byte[] keyBytes = secretKey.getBytes();
            return new SecretKeySpec(keyBytes, ALGORITHM);
        } catch (Exception e) {
            throw new RuntimeException("Anahtar oluşturulurken bir hata oluştu.", e);
        }
    }
}
