package com.m_landalex.webremoteaccess.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractObject {

	protected Long id;
	protected int version;

	@Override
	public String toString() {
		return "id=" + id + ", version=" + version;
	}
	
}
