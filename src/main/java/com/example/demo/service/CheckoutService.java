package com.example.demo.service;

import com.example.demo.models.dto.Purchase;
import com.example.demo.models.dto.PurchaseResponse;
import org.springframework.stereotype.Service;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
