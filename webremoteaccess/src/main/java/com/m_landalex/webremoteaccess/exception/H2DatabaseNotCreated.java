package com.m_landalex.webremoteaccess.exception;

import lombok.ToString;

@ToString
public class H2DatabaseNotCreated extends Exception {

	private static final long serialVersionUID = 1L;

	private String text;

	public H2DatabaseNotCreated(String text) {
		super();
		this.text = text;
	}
	
}
