package com.m_landalex.webremoteaccess.configuration.springhttp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

import com.m_landalex.webremoteaccess.service.EmployeeService;

@Configuration
public class HttpInvokerConfiguration {

	@Autowired
	@Qualifier(value = "employeeServiceImpl")
	private EmployeeService employeeService;
	
	@SuppressWarnings("deprecation")
	@Bean(name = "/httpInvoker/employeeService")
	public HttpInvokerServiceExporter httpInvokerServiceExporter() {
		HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
		exporter.setService(employeeService);
		exporter.setServiceInterface(EmployeeService.class);
		return exporter;
	}
	
}
