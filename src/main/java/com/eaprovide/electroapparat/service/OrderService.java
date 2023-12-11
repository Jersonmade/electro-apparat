package com.eaprovide.electroapparat.service;

import com.eaprovide.electroapparat.dto.order.CartItemsDto;
import com.eaprovide.electroapparat.dto.order.OrderRequest;
import com.eaprovide.electroapparat.model.CartItem;
import com.eaprovide.electroapparat.model.Order;
import com.eaprovide.electroapparat.model.Product;
import com.eaprovide.electroapparat.repo.OrderRepo;
import com.eaprovide.electroapparat.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepo orderRepo;
    private final ProductRepo productRepo;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<CartItem> cartItems = orderRequest.getCartItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setCartItems(cartItems);

        BigDecimal totalCost = calculateTotalCost(cartItems);
        order.setTotalCost(totalCost);

        orderRepo.save(order);
        log.info("order place");
    }

    private CartItem mapToDto(CartItemsDto cartItemsDto) {
        CartItem cartItems = new CartItem();
        cartItems.setQuantity(cartItemsDto.getQuantity());

        Product product = productRepo.findById(cartItemsDto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        cartItems.setProduct(product);
//        cartItems.setProduct(cartItemsDto.getProduct());
        return cartItems;
    }

    private BigDecimal calculateTotalCost(List<CartItem> cartItems) {
        BigDecimal totalCost = BigDecimal.ZERO;
        for (CartItem cartItem : cartItems) {
            int quantity = cartItem.getQuantity();
            BigDecimal itemPrice = cartItem.getProduct().getPrice();

            BigDecimal itemTotalCost = itemPrice.multiply(BigDecimal.valueOf(quantity));
            totalCost = totalCost.add(itemTotalCost);
        }
        return totalCost;
    }
}
