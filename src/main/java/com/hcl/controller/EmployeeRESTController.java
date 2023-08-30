package com.hcl.controller;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.hcl.model.Employee;
import com.hcl.repository.EmployeeRepository;
 
@RestController
@RequestMapping(value = "/api")
public class EmployeeRESTController 
{
  @Autowired
  private EmployeeRepository repository;
 
  public EmployeeRepository getRepository() {
    return repository;
  }
 
  public void setRepository(EmployeeRepository repository) {
    this.repository = repository;
  }
 
  @GetMapping(value = "/employees")
  public List<Employee> getAllEmployees() {
    return repository.findAll();
  }
 
  @PostMapping("/employees")
  Employee createOrSaveEmployee(@RequestBody Employee newEmployee) {
    return repository.save(newEmployee);
  }
 
  @GetMapping("/employees/{id}")
  Employee getEmployeeById(@PathVariable Long id) {
    return repository.findById(id).get();
  }
 
  @PutMapping("/employees/{id}")
  Employee updateEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
 
    return repository.findById(id).map(employee -> {
      employee.setFirstName(newEmployee.getFirstName());
      employee.setLastName(newEmployee.getLastName());
      employee.setEmail(newEmployee.getEmail());
      return repository.save(employee);
    }).orElseGet(() -> {
      newEmployee.setId(id);
      return repository.save(newEmployee);
    });
  }
 
  @DeleteMapping("/employees/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
  }
}

