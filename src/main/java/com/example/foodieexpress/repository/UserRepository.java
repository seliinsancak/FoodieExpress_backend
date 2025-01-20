package com.example.foodieexpress.repository;

import com.example.foodieexpress.entity.User;
import com.example.foodieexpress.entity.enums.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);

    List<User> findByStatus(UserStatus status);

}

