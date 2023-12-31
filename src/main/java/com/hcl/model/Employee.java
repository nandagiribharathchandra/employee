package com.hcl.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "tbl_employee")
public class Employee implements Serializable {
  private static final long serialVersionUID = 1L;
 
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
 
  private String firstName;
 
  private String lastName;
 
  private String email;
 
  public Employee() {
  }
 
  //Getters and setters
 
  @Override
  public String toString() {
    return "EmployeeVO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email  + "]";
  }

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
}