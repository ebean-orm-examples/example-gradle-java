package org.example.domain;

import io.ebean.Model;
import io.ebean.annotation.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Version;
import java.time.LocalDate;

@Entity
public class Customer extends Model {

  public static CustomerFinder find = new CustomerFinder();

  @Id
  Long id;

  @NotNull
  String name;

  //String foo;

  LocalDate startDate;

  @Lob
  String comments;

  @Version
  Long version;

  public Customer(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
