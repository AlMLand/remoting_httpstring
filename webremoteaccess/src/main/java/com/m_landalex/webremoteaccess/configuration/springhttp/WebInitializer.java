package com.m_landalex.webremoteaccess.configuration.springhttp;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.m_landalex.webremoteaccess.configuration.H2Connection;
import com.m_landalex.webremoteaccess.configuration.TransactionManagerBean;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {
			H2Connection.class, TransactionManagerBean.class
		};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {
			HttpInvokerConfiguration.class, WebConfiguration.class
		};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {
				"/invoker/*"
		};
	}

}
