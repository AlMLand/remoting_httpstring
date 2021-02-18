package com.m_landalex.webremoteaccess.configuration.jms;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@ComponentScan(basePackages = "com.m_landalex.webremoteaccess")
@EnableJms
@Configuration
public class AppConfigActiveMQArtemis {
	
	@Value("${activeMQ.url}") private String url;
	@Value("${activeMQ.user}") private String user;
	@Value("${activeMQ.password}") private String password;
	@Value("${jms.concurrency}") private String concurrency;

	@Bean
	public ActiveMQQueue queueAlmland() {
		return new ActiveMQQueue("almland");
	}
	
	@Bean
	public ConnectionFactory connectionFactory() throws JMSException {
		return new ActiveMQConnectionFactory(url, user, password);
	}
	
	@Bean
	public JmsTemplate jmsTemplate() throws JMSException {
		JmsTemplate jmsTemplate = new JmsTemplate();
		jmsTemplate.setConnectionFactory(connectionFactory());
		jmsTemplate.setDefaultDestination(queueAlmland());
		jmsTemplate.afterPropertiesSet();
		return jmsTemplate;
	}
	
	@Bean
	public  DefaultJmsListenerContainerFactory jmsListenerContainerFactory() throws JMSException{
		DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
		defaultJmsListenerContainerFactory.setConnectionFactory(connectionFactory());
		defaultJmsListenerContainerFactory.setConcurrency(concurrency);
		return defaultJmsListenerContainerFactory;
	}
	
}
