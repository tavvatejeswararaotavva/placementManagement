package com.playcode.springboot.crud.RestControllers;

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

import com.playcode.springboot.crud.entity.Employee;
import com.playcode.springboot.crud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
private EmployeeService employeeService;
	
	
	//quick and dirty : inject employee employee Service
	// constructor injection
	@Autowired
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	 
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee the = employeeService.findById(employeeId);
		if(the == null) {
			throw new RuntimeException("employee is not in this organisation" +employeeId);
		}
		return the;
	}
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee TheEmployee) {
		//TheEmployee.setId(0);
		employeeService.save(TheEmployee);
		return TheEmployee;
	}
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee emp) {
		employeeService.save(emp);
		return emp;
	}
	@DeleteMapping("/employees/{employeeId}")
	public String delete(@PathVariable int employeeId) {
		Employee temp = employeeService.findById(employeeId);
		if(temp == null) {
			throw new RuntimeException("employee is not in this organisation" +employeeId);
		}
		employeeService.deleteById(employeeId);
		return "employee was removed from this organisation";
	}
}
