package com.m_landalex.webremoteaccess.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@SuppressWarnings("serial")
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Employee extends AbstractObject implements Serializable{

	@Size(min = 2, max = 50, message = "The value first name should between 2 and 50")
	@NotNull(message = "The value first name cannot be empty")
	private String firstName;
	@Size(min = 2, max = 50, message = "The value last name should between 2 and 50")
	@NotNull(message = "The value last name cannot be empty")
	private String lastName;
	@Past(message = "The value birth date should in the past")
	@NotNull(message = "The value birth date cannot be empty")
	private LocalDate birthDate;
	@Min(value = 0)
	private BigDecimal salary;

	@Override
	public String toString() {
		return "Employee [" + super.toString() + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate="
				+ birthDate + ", salary=" + salary + "]";
	}

}
