package org.example.domain;

//import org.example.domain.query.*;

//import org.example.domain.query.QCustomer;

import io.ebean.Finder;
import org.example.domain.query.QCustomer;

public class CustomerFinder extends Finder<Long,Customer> {

  public CustomerFinder() {
    super(Customer.class);
  }

  public CustomerFinder(String serverName) {
    super(Customer.class, serverName);
  }

  QCustomer where() {
    return new QCustomer();
  }
}
