package org.example.domain;

import io.ebean.Finder;

public class CustomerFinder extends Finder<Long,Customer> {

  public CustomerFinder() {
    super(Customer.class);
  }

}
