package com.example.foodieexpress.service;

import com.example.foodieexpress.dto.request.UserLoginRequestDTO;
import com.example.foodieexpress.dto.request.UserRegisterRequestDTO;
import com.example.foodieexpress.dto.response.UserResponseDTO;
import com.example.foodieexpress.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final List<UserRegisterRequestDTO> userList = new ArrayList<>();
    private long idCounter = 1;  // Kullanıcılar için ID takibi

    // Yeni kullanıcı kaydetme
    public UserResponseDTO registerUser(UserRegisterRequestDTO userDTO) {
        if (!userDTO.password().equals(userDTO.confirmPassword())) {
            throw new IllegalArgumentException("Şifreler eşleşmiyor!");
        }

        // Kullanıcıyı listeye ekle
        UserRegisterRequestDTO newUser = new UserRegisterRequestDTO(userDTO.name(), userDTO.email(), userDTO.password(), userDTO.confirmPassword());
        userList.add(newUser);

        // Yeni kullanıcı için ID ekle
        return new UserResponseDTO(idCounter++, newUser.name(), newUser.email());
    }

    // Kullanıcı giriş işlemi
    public UserResponseDTO loginUser(UserLoginRequestDTO loginDTO) {
        for (UserRegisterRequestDTO user : userList) {
            if (user.email().equals(loginDTO.email()) && user.password().equals(loginDTO.password())) {
                return new UserResponseDTO(idCounter++, user.name(), user.email());
            }
        }
        throw new IllegalArgumentException("Geçersiz e-posta veya şifre!");
    }

    // Tüm kullanıcıları listeleme
    public List<UserResponseDTO> getAllUsers() {
        List<UserResponseDTO> users = new ArrayList<>();
        for (UserRegisterRequestDTO user : userList) {
            users.add(new UserResponseDTO(idCounter++, user.name(), user.email()));
        }
        return users;
    }

    // Kullanıcı ID'sine göre arama
    public Optional<UserResponseDTO> getUserById(Long id) {
        if (id <= 0 || id > idCounter) {
            return Optional.empty();
        }

        for (UserRegisterRequestDTO user : userList) {
            if (id.equals(userList.indexOf(user) + 1L)) {
                return Optional.of(new UserResponseDTO(id, user.name(), user.email()));
            }
        }
        return Optional.empty();
    }
}


