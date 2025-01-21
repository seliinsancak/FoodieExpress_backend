package com.example.foodieexpress.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
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
