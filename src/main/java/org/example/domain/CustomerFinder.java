package org.example.domain;

import io.ebean.Finder;

import java.util.Optional;

public class CustomerFinder extends Finder<Long,Customer> {

  public CustomerFinder() {
    super(Customer.class);
  }

  public Optional<Customer> byIdOptional(Long id) {

    return query()
        .where()
        .idEq(id)
        .findOneOrEmpty();
  }
}
