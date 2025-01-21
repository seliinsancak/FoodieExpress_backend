package com.example.foodieexpress.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_restaurant")
public class Restaurant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String address;
    String phoneNumber;
    Double rating;
    String logo;
    String cuisineType;
    boolean isActive;


    @OneToMany(mappedBy = "restaurant")
    private List<Menu> menuList;  // Restorana ait menüler (çoklu menü olabilir)

    @OneToMany(mappedBy = "restaurant")
    private List<Order> orders;  // Restoranın aldığı siparişler

    @OneToMany(mappedBy = "restaurant")
    private List<Review> reviews;  // Restoranın aldığı yorumlar
}


