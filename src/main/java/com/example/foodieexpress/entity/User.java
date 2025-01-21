package com.example.foodieexpress.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String firstName;
    String lastName;
    String email;
    String username;
    String password;
    String phone;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;  // Kullanıcının verdiği siparişler

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;  // Kullanıcının yazdığı yorumlar
}
