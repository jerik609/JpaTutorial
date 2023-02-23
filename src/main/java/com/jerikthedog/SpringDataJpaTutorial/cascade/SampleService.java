package com.jerikthedog.SpringDataJpaTutorial.cascade;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    SampleService(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void saveCustomer(Customer customer) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        final var transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(customer);
        transaction.commit();
    }

    public void saveOrder(Order order) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        final var transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(order);
        transaction.commit();
    }

}
