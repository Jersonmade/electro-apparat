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
@Table(name = "t_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;

    //    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "t_order_cart_items",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "cart_item_id"))
    private List<CartItem> cartItems;
    private BigDecimal totalCost;
}
