package com.example.demo.service;

import com.example.demo.models.dto.Purchase;
import com.example.demo.models.dto.PurchaseResponse;
import com.example.demo.models.order.Customer;
import com.example.demo.models.order.Order;
import com.example.demo.models.order.OrderItem;
import com.example.demo.models.order.ShipAddress;
import com.example.demo.repos.CustomerRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;
@Service
public class CheckoutServiceImpl implements CheckoutService{
    private CustomerRepo customerRepo;

    public CheckoutServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        //retrieve order infos from dto
        var order = purchase.getOrder();
        //generate trackig number
        String orderTrackingNumber=generateOrderTrackNumb();
        order.setOrderTrackingNumber(orderTrackingNumber);
        //populate order with orderItems
        var orderItems = purchase.getOrderItems();
        orderItems.forEach(item->order.addOrderItem(item));
        //populate order with ShippingAddress
        var shipAddress = purchase.getShipAddress();
        order.setShipAddress(shipAddress);
        //populate customer with order
        var customer = purchase.getCustomer();
        customer.addOrder(order);
        //save to db
customerRepo.save(customer);
        //return response
return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackNumb() {
        //geneate random UUID
        return UUID.randomUUID().toString();
    }


}
