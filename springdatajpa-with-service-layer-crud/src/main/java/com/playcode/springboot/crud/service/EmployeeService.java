package com.playcode.springboot.crud.service;

import java.util.List;

import com.playcode.springboot.crud.entity.Employee;

public interface EmployeeService {
public List<Employee> findAll();
public Employee findById(int theId);
public void save(Employee theEmployee);
public void deleteById(int theId);

}
