package org.example.domain;

import io.ebean.Ebean;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;


public class CustomerTest {

  @Test
  public void saveAndFind() {

    Customer customer = new Customer("Hello Rob");
    customer.setStartDate(LocalDate.now());
    customer.setComments("What is this good for?");

    customer.save();
    //Ebean.save(customer);

    assertNotNull(customer.getId());

    Optional<Customer> found = Customer.find
        .where()
        .id.eq(customer.getId())
        .findOneOrEmpty();

//    Optional<Customer> found = Ebean.find(Customer.class)
//      .where()
//      .idEq(customer.getId())
//      .findOneOrEmpty();

    assertTrue(found.isPresent());
    found.ifPresent(it -> {
        assertEquals(it.getId(), customer.getId());
        assertEquals(it.getName(), customer.getName());
      }
    );

//    Customer.find
//      .where()
//      .id.isNotNull()
//      .findEach();

    Ebean.find(Customer.class)
      .where().isNotNull("id")
      .findEach(it -> {
        System.out.println("hello " + it.getName());
        System.out.println(".. started on: " + it.getStartDate());
      });


    List<Customer> hells = new CustomerFinder().where()
      .name.istartsWith("hell")
      //.foo.startsWith("oh")
      .id.greaterThan(1)
      .findList();

    System.out.println("hells:"+hells);
  }

}