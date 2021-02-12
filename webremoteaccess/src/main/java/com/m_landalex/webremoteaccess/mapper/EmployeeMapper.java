package com.m_landalex.webremoteaccess.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.m_landalex.webremoteaccess.data.Employee;
import com.m_landalex.webremoteaccess.domain.EmployeeEntity;

@Component
public class EmployeeMapper extends AbstractMapper<Employee, EmployeeEntity> {

	@Autowired
	public EmployeeMapper() {
		super(Employee.class, EmployeeEntity.class);
	}

}
