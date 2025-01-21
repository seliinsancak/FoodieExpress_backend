package com.example.foodieexpress.service;

import com.example.foodieexpress.dto.request.UserLoginRequestDTO;
import com.example.foodieexpress.dto.request.UserRegisterRequestDTO;
import com.example.foodieexpress.dto.response.UserResponseDTO;
import com.example.foodieexpress.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final List<User> userList = new ArrayList<>();
    private long idCounter = 1;

    // Yeni kullanıcı kaydetme
    public UserResponseDTO registerUser(UserRegisterRequestDTO userDTO) {
        if (!userDTO.password().equals(userDTO.confirmPassword())) {
            throw new IllegalArgumentException("Şifreler eşleşmiyor!");
        }

        // Kullanıcıyı yeni oluşturup listeye ekle
        User newUser = new User(
                idCounter++,
                userDTO.name(),
                "",  // Last name boş
                userDTO.email(),
                userDTO.email(),  // Username'i email ile aynı yapabiliriz
                userDTO.password(),
                ""
        );

        userList.add(newUser);

        // Yeni kullanıcı için UserResponseDTO oluştur
        return new UserResponseDTO(newUser.getId(), newUser.getFirstName(), newUser.getEmail());
    }

    // Kullanıcı giriş işlemi
    public UserResponseDTO loginUser(UserLoginRequestDTO loginDTO) {
        for (User user : userList) {
            if (user.getEmail().equals(loginDTO.email()) && user.getPassword().equals(loginDTO.password())) {
                return new UserResponseDTO(user.getId(), user.getFirstName(), user.getEmail());
            }
        }
        throw new IllegalArgumentException("Geçersiz e-posta veya şifre!");
    }

    // Tüm kullanıcıları listeleme
    public List<UserResponseDTO> getAllUsers() {
        List<UserResponseDTO> users = new ArrayList<>();
        for (User user : userList) {
            users.add(new UserResponseDTO(user.getId(), user.getFirstName(), user.getEmail()));
        }
        return users;
    }

    // Kullanıcı ID'sine göre arama
    public Optional<UserResponseDTO> getUserById(Long id) {
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return Optional.of(new UserResponseDTO(user.getId(), user.getFirstName(), user.getEmail()));
            }
        }
        return Optional.empty();
    }
}



