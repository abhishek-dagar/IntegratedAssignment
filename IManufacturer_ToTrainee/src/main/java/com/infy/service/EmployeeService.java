package com.infy.service;

import com.infy.dto.EmployeeDTO;
import com.infy.exception.InfyEmployeeException;

public interface EmployeeService {
	public Integer addEmployee(EmployeeDTO employee) throws InfyEmployeeException;

	public EmployeeDTO getEmployeeDetails(Integer employeeId) throws InfyEmployeeException;

	public void updateEmployee(Integer employeeId, String emailId) throws InfyEmployeeException;

	public void deleteEmployee(Integer employeeId) throws InfyEmployeeException;

}
