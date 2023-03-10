package com.jerikthedog.SpringDataJpaTutorial.cascade;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

// https://stackoverflow.com/questions/73156573/onetomany-foreign-key-is-null

// PARENT ENTITY

@Entity
@Table(name = "cs_customers")
public class Customer {
    @Id
    @GeneratedValue
    private long customer_id;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orderList = new ArrayList<>();

    public void addOrder(Order order) {
        orderList.add(order);
        order.setCustomer(this);
    }
}
