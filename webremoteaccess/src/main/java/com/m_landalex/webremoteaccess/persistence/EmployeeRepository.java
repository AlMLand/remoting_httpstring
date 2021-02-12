package com.m_landalex.webremoteaccess.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m_landalex.webremoteaccess.domain.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

	List<EmployeeEntity> findByLastName(String lastName);
	
}
