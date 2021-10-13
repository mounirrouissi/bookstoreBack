package com.example.demo.models.dto;

import com.example.demo.models.order.Customer;
import com.example.demo.models.order.Order;
import com.example.demo.models.order.OrderItem;
import com.example.demo.models.order.ShipAddress;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    private Customer customer;
    private ShipAddress shipAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
