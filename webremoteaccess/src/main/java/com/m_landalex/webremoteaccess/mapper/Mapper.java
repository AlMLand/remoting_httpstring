package com.m_landalex.webremoteaccess.mapper;

import java.util.List;

import com.m_landalex.webremoteaccess.data.AbstractObject;
import com.m_landalex.webremoteaccess.domain.AbstractEntity;

public interface Mapper <T extends AbstractObject, S extends AbstractEntity>{
	
	T toDto(S entity);
	List<T> toDtoList(List<S> entityList);
	S toEntity(T dto);
	List<S> toEntityList(List<T> dtoList);
	
}
