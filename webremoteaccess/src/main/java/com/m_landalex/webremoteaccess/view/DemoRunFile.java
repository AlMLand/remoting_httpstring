package com.m_landalex.webremoteaccess.view;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.m_landalex.webremoteaccess.configuration.H2Connection;
import com.m_landalex.webremoteaccess.service.EmployeeService;

public class DemoRunFile {

	public static void main(String[] args) {
		
		GenericApplicationContext context = new AnnotationConfigApplicationContext(H2Connection.class);
		EmployeeService service = context.getBean("employeeServiceImpl", EmployeeService.class);
		
		System.out.println(service.fetchByLastName("Nurmagomedov"));
		
		context.close();
		
	}

}
