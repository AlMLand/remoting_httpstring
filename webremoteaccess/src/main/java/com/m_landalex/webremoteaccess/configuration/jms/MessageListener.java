package com.m_landalex.webremoteaccess.configuration.jms;

import javax.jms.Message;

public interface MessageListener {

	void onMessage(Message message);
	
}
