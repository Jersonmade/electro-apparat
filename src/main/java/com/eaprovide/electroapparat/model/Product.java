package com.eaprovide.electroapparat.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "t_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameId;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String manufactory;
    private String categories;
    private String subcategory;
    private BigDecimal price;
    private List<String> images;
    private List<String> documentations;
}
