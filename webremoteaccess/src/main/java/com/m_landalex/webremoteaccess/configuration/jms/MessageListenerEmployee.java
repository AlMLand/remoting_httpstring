package com.m_landalex.webremoteaccess.configuration.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListenerEmployee implements MessageListener {

	private static final Logger logger = LoggerFactory.getLogger(MessageListenerEmployee.class);
	
	@JmsListener(destination = "almland", containerFactory = "jmsListenerContainerFactory")
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try {
			logger.info("--> Received: {}", textMessage.getText());
		} catch (JMSException e) {
			logger.error("JMS Error {}", e);
		}
	}
	
}
