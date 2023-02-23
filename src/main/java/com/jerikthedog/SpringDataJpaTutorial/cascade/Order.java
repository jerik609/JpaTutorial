package com.jerikthedog.SpringDataJpaTutorial.cascade;

import jakarta.persistence.*;

// CHILD ENTITY

@Entity
@Table(name = "cs_orders")
public class Order {
    @Id
    @GeneratedValue
    private long order_id;

    @ManyToOne
    @JoinColumn(name = "customer_fk")
    private Customer customer;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
