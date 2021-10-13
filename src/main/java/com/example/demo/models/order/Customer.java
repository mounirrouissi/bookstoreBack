package com.example.demo.models.order;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
private String lastName;
private String email;
@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
private Set<Order> orders=new HashSet<>();


    public void addOrder(Order item){
        if(item !=null)
        {
            if (orders ==null)
                orders =new HashSet<>();
            this.orders.add(item);
            item.setCustomer(this);
        }

    }
}
