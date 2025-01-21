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
@Table(name = "tbl_restaurant")  // Tablo adı belirtilebilir
public class Restaurant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;  // Restaurant için benzersiz ID

    String name;  // Restoran adı
    String address;  // Restoran adresi
    String phoneNumber;  // Restoran telefon numarası
    Double rating;
    String logo;  // Restoran logosu (isteğe bağlı)
    String cuisineType;  // Restoran mutfağı (örneğin, Türk, İtalyan vs.)
    boolean isActive;  // Restoranın aktif olup olmadığını belirtir (açık/kapalı)


    @OneToMany(mappedBy = "restaurant")
    private List<Menu> menuList;  // Restorana ait menüler (çoklu menü olabilir)

    @OneToMany(mappedBy = "restaurant")
    private List<Order> orders;  // Restoranın aldığı siparişler

    @OneToMany(mappedBy = "restaurant")
    private List<Review> reviews;  // Restoranın aldığı yorumlar
}


