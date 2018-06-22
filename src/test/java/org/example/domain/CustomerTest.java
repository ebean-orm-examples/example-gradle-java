package org.example.domain;


import org.junit.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class CustomerTest {

	@Test
	public void saveAndFind() {

		Customer customer = new Customer("Hello Rob");
		customer.setStartDate(LocalDate.now());
		customer.setComments("What is this good for?");

		customer.save();

		assertNotNull(customer.getId());

		Optional<Customer> found = Customer.find.byIdOptional(customer.getId());

		assertTrue(found.isPresent());
		found.ifPresent(it -> {
					assertEquals(it.getId(), customer.getId());
					assertEquals(it.getName(), customer.getName());
				}
		);

		Customer.find.query()
				.where().isNotNull("id")
				.findEach(it -> {
					System.out.println("hello " + it.getName());
					System.out.println(".. started on: " + it.getStartDate());
				});


		List<Customer> bats = Customer.find
				.query()
				.where()
				.startsWith("name", "BatOutOfHell")
				.gt("id", 1)
				.findList();

		System.out.println("bats:" + bats);
	}

}
