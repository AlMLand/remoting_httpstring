package com.m_landalex.webremoteaccess.configuration.springhttp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

import com.m_landalex.webremoteaccess.service.EmployeeService;

@Configuration
public class RemoteClientConfiguration {

	@SuppressWarnings("deprecation")
	@Bean
	public EmployeeService employeeService() {
		HttpInvokerProxyFactoryBean bean = new HttpInvokerProxyFactoryBean();
		bean.setServiceInterface(EmployeeService.class);
		bean.setServiceUrl("http://localhost:8080/webremoteaccess/invoker/httpInvoker/employeeService");
		bean.afterPropertiesSet();
		return (EmployeeService) bean.getObject();
	}
	
}
