package com.example.foodieexpress.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class CloudinaryService {
    public String uploadFile(MultipartFile file) throws IOException {
        // Dosyayı yükleme işlemi
        return "uploadedFileUrl";
    }
}

