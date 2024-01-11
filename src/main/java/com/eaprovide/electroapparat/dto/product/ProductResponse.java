package com.eaprovide.electroapparat.dto.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private Long id;
    private String nameId;
    private String name;
    private String description;
    private String manufactory;
    private String categories;
    private String subcategory;
    private BigDecimal price;
    private List<String> images;
}
