package com.example.demo.controllers;

import com.example.demo.models.dto.Purchase;
import com.example.demo.models.dto.PurchaseResponse;
import com.example.demo.service.CheckoutService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin("*")
public class CheckoutController {
    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase)
    {
        System.out.println("purchase===="+ purchase);
        return checkoutService.placeOrder(purchase);
    }
}
