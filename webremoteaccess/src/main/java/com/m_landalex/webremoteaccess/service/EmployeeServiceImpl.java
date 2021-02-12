package com.m_landalex.webremoteaccess.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.m_landalex.webremoteaccess.data.Employee;
import com.m_landalex.webremoteaccess.mapper.EmployeeMapper;
import com.m_landalex.webremoteaccess.persistence.EmployeeRepository;
import com.m_landalex.webremoteaccess.validation.EmployeeValidationService;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployeeValidationService employeeValidationService;

	@Transactional(readOnly = true)
	@Override
	public List<Employee> fetchByLastName(String lastName) {
		return employeeMapper.toDtoList(employeeRepository.findByLastName(lastName));
	}

	@Transactional(readOnly = true)
	@Override
	public List<Employee> fetchAll() {
		return employeeMapper.toDtoList(employeeRepository.findAll());
	}

	@Transactional(readOnly = true)
	@Override
	public Employee fetchById(Long id) {
		return employeeMapper.toDto(employeeRepository.findById(id).get());
	}

	@Override
	public Employee save(Employee employee) {
		if (employeeValidationService.validateEmployee(employee)) {
			employeeRepository.save(employeeMapper.toEntity(employee));
			return employee;
		} else {
			return employee;
		}
	}

	@Override
	public void delete(Employee employee) {
		employeeRepository.delete(employeeMapper.toEntity(employee));
	}

	@Transactional(propagation = Propagation.NEVER)
	@Override
	public Long countEmployee() {
		return employeeRepository.count();
	}

}
