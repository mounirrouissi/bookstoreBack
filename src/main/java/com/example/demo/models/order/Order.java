package com.example.demo.models.order;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderTrackingNumber;
    private int  totalQuantity;
    private BigDecimal totalPrice;
    private String status;
    @CreationTimestamp
    private Date dateCreated;
    @UpdateTimestamp
    private Date dateUpdated;
    @OneToMany (cascade = CascadeType.ALL,mappedBy = "order")
    private Set<OrderItem> orderItems=new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_address_id",referencedColumnName = "id")
    private ShipAddress shipAddress;


    public void addOrderItem(OrderItem item){
        if(item !=null)
        {
            if (orderItems ==null)
                orderItems =new HashSet<>();
            this.orderItems.add(item);
            item.setOrder(this);
        }

    }
}
