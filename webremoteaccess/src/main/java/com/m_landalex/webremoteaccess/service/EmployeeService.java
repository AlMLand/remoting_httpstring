package com.m_landalex.webremoteaccess.service;

import java.util.List;

import com.m_landalex.webremoteaccess.data.Employee;

public interface EmployeeService {

	List<Employee> fetchByLastName(String lastName);
	List<Employee> fetchAll();
	Employee fetchById(Long id);
	Employee save(Employee employee);
	void delete(Employee employee);
	Long countEmployee();
	
}
