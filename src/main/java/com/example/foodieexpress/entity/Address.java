package com.example.foodieexpress.entity;

import com.example.foodieexpress.entity.enums.EState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_address")
public class Address extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String street;
    String city;

    @Enumerated(EnumType.STRING)
    EState state;
    String country;
    String postalCode;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;

}


