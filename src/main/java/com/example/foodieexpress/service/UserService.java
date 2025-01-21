package com.example.foodieexpress.service;

import com.example.foodieexpress.dto.request.UserLoginRequestDTO;
import com.example.foodieexpress.dto.request.UserRegisterRequestDTO;
import com.example.foodieexpress.dto.response.UserResponseDTO;
import com.example.foodieexpress.entity.User;
import com.example.foodieexpress.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // Yeni kullanıcı kaydetme
    public UserResponseDTO registerUser(UserRegisterRequestDTO userDTO) {
        if (!userDTO.password().equals(userDTO.confirmPassword())) {
            throw new IllegalArgumentException("Şifreler eşleşmiyor!");
        }

        User newUser = User.builder()
                .firstName(userDTO.name())
                .email(userDTO.email())
                .password(userDTO.password())
                .phone("")  // Telefon bilgisi ekleyebilirsiniz
                .build();

        userRepository.save(newUser);

        return new UserResponseDTO(newUser.getId(), newUser.getFirstName(), newUser.getEmail());
    }

    // Kullanıcı giriş işlemi
    public UserResponseDTO loginUser(UserLoginRequestDTO loginDTO) {
        Optional<User> user = userRepository.findByEmail(loginDTO.email());
        if (user.isPresent() && user.get().getPassword().equals(loginDTO.password())) {
            return new UserResponseDTO(user.get().getId(), user.get().getFirstName(), user.get().getEmail());
        }
        throw new IllegalArgumentException("Geçersiz e-posta veya şifre!");
    }

    // Tüm kullanıcıları listeleme
    public List<UserResponseDTO> getAllUsers() {
        List<UserResponseDTO> users = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            users.add(new UserResponseDTO(user.getId(), user.getFirstName(), user.getEmail()));
        }
        return users;
    }

    // Kullanıcı ID'sine göre arama
    public Optional<UserResponseDTO> getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(u -> new UserResponseDTO(u.getId(), u.getFirstName(), u.getEmail()));
    }
}
