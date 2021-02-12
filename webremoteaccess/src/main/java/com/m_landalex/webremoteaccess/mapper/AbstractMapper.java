package com.m_landalex.webremoteaccess.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.m_landalex.webremoteaccess.data.AbstractObject;
import com.m_landalex.webremoteaccess.domain.AbstractEntity;

public abstract class AbstractMapper<T extends AbstractObject, S extends AbstractEntity> implements Mapper<T, S> {

	@Autowired
	private ModelMapper modelMapper;
	private Class<T> dto;
	private Class<S> entity;
	
	public AbstractMapper(Class<T> dto, Class<S> entity) {
		super();
		this.dto = dto;
		this.entity = entity;
	}
	
	@Override
	public S toEntity(T dto) {
		return Objects.isNull(dto) ? null : modelMapper.map(dto, entity);
	}
	
	@Override
	public List<S> toEntityList(List<T> dtoList) {
		return Objects.isNull(dtoList) ? new ArrayList<>()
				: dtoList.stream().map(object -> modelMapper.map(object, entity)).collect(Collectors.toList());
	}
	
	@Override
	public T toDto(S entity) {
		return Objects.isNull(entity) ? null : modelMapper.map(entity, dto);
	}
	
	@Override
	public List<T> toDtoList(List<S> entityList) {
		return Objects.isNull(entityList) ? new ArrayList<>()
				: entityList.stream().map(entity -> modelMapper.map(entity, dto)).collect(Collectors.toList());
	}

}
