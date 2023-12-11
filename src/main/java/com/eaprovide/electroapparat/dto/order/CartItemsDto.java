package com.eaprovide.electroapparat.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemsDto {
    private Long id;
    private int quantity;
    private Long productId;
}
