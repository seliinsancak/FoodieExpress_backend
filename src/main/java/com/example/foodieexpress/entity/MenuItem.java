package com.example.foodieexpress.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblMenuItem")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;  // Menü öğesi için benzersiz ID

    String name;  // Menü öğesinin adı
    String description;  // Menü öğesinin açıklaması
    BigDecimal price;  // Menü öğesinin fiyatı
    String imageUrl;  // Menü öğesinin resminin URL'si

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;  // İlgili menü (bir menü, birden fazla öğe içerebilir)

    @ManyToMany
    @JoinTable(
            name = "tblOrderItem_MenuItem",
            joinColumns = @JoinColumn(name = "menu_item_id"),
            inverseJoinColumns = @JoinColumn(name = "order_item_id")
    )
    private List<OrderItem> orderItems;  // Menü öğesinin siparişlerde yer alabileceği ilişki
}
