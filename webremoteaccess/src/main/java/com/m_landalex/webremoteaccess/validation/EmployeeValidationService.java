package com.m_landalex.webremoteaccess.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m_landalex.webremoteaccess.data.Employee;

@Service
public class EmployeeValidationService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeValidationService.class);

	@Autowired
	private Validator validator;

	public boolean validateEmployee(Employee employee) {
		Set<ConstraintViolation<Employee>> returnedSet = validator.validate(employee);
		if (returnedSet.size() > 0) {
			logger.info("Quantity of violations: {}", returnedSet.size());
			returnedSet.forEach(violation -> {
				logger.info("Validation for property: {}, with value: {}, with error message: {}",
						violation.getPropertyPath(), violation.getInvalidValue(), violation.getMessage());
			});
			return false;
		} else {
			return true;
		}
	}

}
