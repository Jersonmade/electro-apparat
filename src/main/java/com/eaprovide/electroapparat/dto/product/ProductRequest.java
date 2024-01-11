package com.eaprovide.electroapparat.dto.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String nameId;
    private String name;
    private String description;
    private String manufactory;
    private String categories;
    private String subcategory;
    private BigDecimal price;
    private List<String> images;
}
