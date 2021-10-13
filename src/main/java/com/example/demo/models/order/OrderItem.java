package com.example.demo.models.order;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String imageUrl;
    private BigDecimal price;
    private int quantity;
    private Long productId;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;



}
