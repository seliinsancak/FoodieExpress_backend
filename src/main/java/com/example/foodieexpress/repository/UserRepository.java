package com.example.foodieexpress.repository;

import com.example.foodieexpress.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);  // Kullanıcıyı email ile bul

    Boolean existsByEmail(String email);  // Email kontrolü

    Boolean existsByPhone(String phone);  // Telefon numarası kontrolü

    Optional<User> findByPhone(String phone);  // Telefon numarası ile kullanıcı bul


    Optional<User> findById(Long id);
}
