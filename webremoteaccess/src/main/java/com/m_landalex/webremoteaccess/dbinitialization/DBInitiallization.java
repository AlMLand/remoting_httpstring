package com.m_landalex.webremoteaccess.dbinitialization;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.m_landalex.webremoteaccess.data.Employee;
import com.m_landalex.webremoteaccess.service.EmployeeService;

@Service
public class DBInitiallization {

	@Autowired
	@Qualifier(value = "employeeServiceImpl")
	private EmployeeService employeeService;
	
	@PostConstruct
	public void init() {
		
		employeeService.save(Employee.builder().firstName("Conor").lastName("McGregor").birthDate(LocalDate.of(1985, 1, 1))
						.salary(new BigDecimal(5000.00)).build());

		employeeService.save(Employee.builder().firstName("Dustin").lastName("Porier")
				.birthDate(LocalDate.of(1987, 2, 2)).salary(new BigDecimal(4000.00)).build());

		employeeService.save(Employee.builder().firstName("Habib").lastName("Nurmagomedov")
				.birthDate(LocalDate.of(1990, 3, 3)).salary(new BigDecimal(6000.00)).build());
	}
	
}
