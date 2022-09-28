package com.infy.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.EmployeeDTO;
import com.infy.exception.InfyEmployeeException;
import com.infy.repository.EmployeeRepository;
import com.infy.validator.Validator;

@Service(value = "employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepositoryImpl;

	@Override
	public Integer addEmployee(EmployeeDTO employee) throws InfyEmployeeException {
		Validator.validate(employee);
		if (employeeRepositoryImpl.getEmployeeDetails(employee.getEmployeeId()) != null) {
			throw new InfyEmployeeException("Service.EMPLOYEE_ALREADY_PRESENT");
		}
		return employeeRepositoryImpl.addEmployee(employee);
	}

	@Override
	public EmployeeDTO getEmployeeDetails(Integer employeeId) throws InfyEmployeeException {
		if (employeeRepositoryImpl.getEmployeeDetails(employeeId) == null) {
			throw new InfyEmployeeException("Service.EMPLOYEE_NOT_FOUND");
		}
		return employeeRepositoryImpl.getEmployeeDetails(employeeId);
	}

	@Override
	public void updateEmployee(Integer employeeId, String emailId) throws InfyEmployeeException {
		if (employeeRepositoryImpl.getEmployeeDetails(employeeId) == null) {
			throw new InfyEmployeeException("Service.EMPLOYEE_NOT_FOUND");
		}
		employeeRepositoryImpl.updateEmployee(employeeId, emailId);
	}

	@Override
	public void deleteEmployee(Integer employeeId) throws InfyEmployeeException {
		if (employeeRepositoryImpl.getEmployeeDetails(employeeId) == null) {
			throw new InfyEmployeeException("Service.EMPLOYEE_NOT_FOUND");
		}
		employeeRepositoryImpl.deleteEmployee(employeeId);
	}
}
