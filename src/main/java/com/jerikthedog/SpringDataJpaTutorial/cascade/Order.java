package com.jerikthedog.SpringDataJpaTutorial.cascade;

import jakarta.persistence.*;

@Entity
@Table(name = "cs_orders")
public class Order {
    @Id
    @GeneratedValue
    private long order_id;

    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_fk")
    private Customer customer;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
