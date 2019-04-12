package org.example.domain;

import io.ebean.Finder;
import org.example.domain.query.QCustomer;

import java.util.Optional;

public class CustomerFinder extends Finder<Long,Customer> {

  public CustomerFinder() {
    super(Customer.class);
  }

  public Optional<Customer> byIdOptional(Long id) {

    return new QCustomer()
        .id.equalTo(id)
        .findOneOrEmpty();
  }

  public Customer findByName(String name) {
    return new QCustomer()
      .name.istartsWith(name)
      .findOne();
  }

}
