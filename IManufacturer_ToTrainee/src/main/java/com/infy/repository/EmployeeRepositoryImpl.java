package com.infy.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.infy.dto.EmployeeDTO;
import com.infy.entity.Employee;

@Repository(value = "employeeRepository")
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Integer addEmployee(EmployeeDTO employeeDTO) {
		Employee employee = new Employee();
		employee.setEmployeeId(employeeDTO.getEmployeeId());
		employee.setName(employeeDTO.getName());
		employee.setEmailId(employeeDTO.getEmailId());
		employee.setDateOfBirth(employeeDTO.getDateOfBirth());
		employee.setManufacturingUnit(employeeDTO.getManufacturingUnit());
		entityManager.persist(employee);
		employee.setManufacturingUnit(employeeDTO.getManufacturingUnit());
		return employee.getEmployeeId();
	}

	@Override
	public EmployeeDTO getEmployeeDetails(Integer employeeId) {
		EmployeeDTO employeeDTO = null;
		Employee employee = entityManager.find(Employee.class, employeeId);
		if (employee != null) {
			employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployeeId(employee.getEmployeeId());
			employeeDTO.setName(employee.getName());
			employeeDTO.setEmailId(employee.getEmailId());
			employeeDTO.setDateOfBirth(employee.getDateOfBirth());
			employeeDTO.setManufacturingUnit(employee.getManufacturingUnit());
		}
		return employeeDTO;
	}

	@Override
	public void updateEmployee(Integer employeeId, String emailId) {
		Employee employee = entityManager.find(Employee.class, employeeId);
		employee.setEmailId(emailId);
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		Employee employee = entityManager.find(Employee.class, employeeId);
		entityManager.remove(employee);
	}

}