package com.playcode.springboot.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.playcode.springboot.crud.dao.EmployeeRepository;
import com.playcode.springboot.crud.entity.Employee;
@Service
public class EmployeeServices implements EmployeeService {
	private EmployeeRepository employeeRepository;
	@Autowired
	public EmployeeServices(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}
	@Override
	
	public List<Employee> findAll() {
		return employeeRepository.findAll(); 
	}

	@Override

	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		Employee emp =null;
		if(result.isPresent()) {
			emp = result.get();
		}
		else {
			throw new RuntimeException("not found");
		}
		return emp;
	}

	@Override
	

	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}
