package com.jerikthedog.SpringDataJpaTutorial;

import com.jerikthedog.SpringDataJpaTutorial.cascade.Customer;
import com.jerikthedog.SpringDataJpaTutorial.cascade.Order;
import com.jerikthedog.SpringDataJpaTutorial.cascade.SampleService;
import com.jerikthedog.SpringDataJpaTutorial.repository.CascadeCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaTutorialApplication {

	private final SampleService service;

	@Autowired
	SpringDataJpaTutorialApplication(SampleService service) {
		this.service = service;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaTutorialApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner run() {
//		return args -> {
//			final var order = new Order();
//			final var customer = new Customer();
//			customer.addOrder(order);
//			service.saveCustomer(customer);
//
//			System.out.println("=======================================");
//
//			final var order2 = new Order();
//			order2.setCustomer(customer);
//			service.saveOrder(order2);
//		};
//	}
}
