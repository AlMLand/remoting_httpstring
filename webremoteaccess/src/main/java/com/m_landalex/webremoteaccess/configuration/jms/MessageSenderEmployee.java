package com.m_landalex.webremoteaccess.configuration.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class MessageSenderEmployee implements MessageSender {

	private static final Logger logger = LoggerFactory.getLogger(MessageSenderEmployee.class);
	
	@Autowired private JmsTemplate jmsTemplate;

	@Override
	public void sendMessage(final String message) {
		jmsTemplate.setDeliveryDelay(500L);
		jmsTemplate.send(new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage jmsMessage = session.createTextMessage(message);
				logger.info("--> Sending: {}", jmsMessage.getText());
				return jmsMessage;
			}
		});
	}
	
}
