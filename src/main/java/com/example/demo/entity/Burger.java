package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Burger {


    private Long id;

    private String name;

    private Integer price;

    private Boolean isVegan;

    @Enumerated(EnumType.STRING)
    private BreadType breadType;

    private String contents;
}
