package com.jerikthedog.SpringDataJpaTutorial.repository;

import com.jerikthedog.SpringDataJpaTutorial.cascade.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CascadeCustomerRepository extends JpaRepository<Customer, Long> {
}
