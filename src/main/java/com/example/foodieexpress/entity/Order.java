package com.example.foodieexpress.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblOrder")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;  // Sipariş için benzersiz ID

    LocalDateTime orderTime;  // Siparişin verildiği zaman
    String status;  // Sipariş durumu (örn. "Hazırlanıyor", "Teslim Edildi", "İptal Edildi")

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // Siparişi veren kullanıcı

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;  // Siparişin verildiği restoran

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;  // Siparişteki ürünler
}

