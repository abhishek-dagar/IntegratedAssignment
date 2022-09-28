package com.infy.dto;

import java.time.LocalDate;

public class EmployeeDTO {

	private Integer employeeId;
	private String emailId;
	private String name;
	private LocalDate dateOfBirth;
	private ManufacturingUnit manufacturingUnit;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public ManufacturingUnit getManufacturingUnit() {
		return manufacturingUnit;
	}

	public void setManufacturingUnit(ManufacturingUnit manufacturingUnit) {
		this.manufacturingUnit = manufacturingUnit;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [employeeId=" + employeeId + ", emailId=" + emailId + ", name=" + name + ", dateOfBirth="
				+ dateOfBirth + ", manufacturingUnit=" + manufacturingUnit + "]";
	}

}
