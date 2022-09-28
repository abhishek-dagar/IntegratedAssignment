package com.infy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.infy.dto.EmployeeDTO;
import com.infy.dto.ManufacturingUnit;
import com.infy.exception.InfyEmployeeException;
import com.infy.repository.EmployeeRepository;
import com.infy.service.EmployeeServiceImpl;

@SpringBootTest
public class IManufacturerToTraineeApplicationTests {

	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();

	@Test
	public void addEmployeeInvalidEmailId() throws Exception {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmployeeId(2006);
		employeeDTO.setName("Wilson");
		employeeDTO.setEmailId("wilson@mail.com");
		employeeDTO.setDateOfBirth(LocalDate.of(1996, 4, 10));
		employeeDTO.setManufacturingUnit(ManufacturingUnit.U001);
		Mockito.when(employeeRepository.addEmployee(employeeDTO)).thenReturn(2006);
		employeeDTO.setEmailId("wilsonmail.com"); // for wrong output
		InfyEmployeeException actual = assertThrows(InfyEmployeeException.class,
				() -> employeeServiceImpl.addEmployee(employeeDTO));
		assertEquals("Validator.INVALID_EMAIL_ID", actual.getMessage());
	}

	@Test
	public void getEmployeeInvalidEmployeeId() throws Exception {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmployeeId(2001);
		employeeDTO.setName("Wilson");
		employeeDTO.setEmailId("wilson@mail.com");
		employeeDTO.setDateOfBirth(LocalDate.of(1996, 4, 10));
		employeeDTO.setManufacturingUnit(ManufacturingUnit.U001);
		Mockito.when(employeeRepository.getEmployeeDetails(employeeDTO.getEmployeeId())).thenReturn(employeeDTO);
		InfyEmployeeException actual = assertThrows(InfyEmployeeException.class,
				() -> employeeServiceImpl.getEmployeeDetails(2002));
		assertEquals("Service.EMPLOYEE_NOT_FOUND", actual.getMessage());
	}

	@Test
	public void updateEmployeeInvalidEmployeeId() throws Exception {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmployeeId(2001);
		employeeDTO.setName("Wilson");
		employeeDTO.setEmailId("wilson@mail.com");
		employeeDTO.setDateOfBirth(LocalDate.of(1996, 4, 10));
		employeeDTO.setManufacturingUnit(ManufacturingUnit.U001);
		Mockito.doNothing().when(employeeRepository).updateEmployee(employeeDTO.getEmployeeId(),
				employeeDTO.getEmailId());
		InfyEmployeeException actual = assertThrows(InfyEmployeeException.class,
				() -> employeeServiceImpl.updateEmployee(2002, "wilson01@mail.com"));
		assertEquals("Service.EMPLOYEE_NOT_FOUND", actual.getMessage());
	}

	@Test
	public void deleteEmployeeInvalidEmployeeId() throws Exception {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmployeeId(2001);
		employeeDTO.setName("Wilson");
		employeeDTO.setEmailId("wilson@mail.com");
		employeeDTO.setDateOfBirth(LocalDate.of(1996, 4, 10));
		employeeDTO.setManufacturingUnit(ManufacturingUnit.U001);
		Mockito.doNothing().when(employeeRepository).deleteEmployee(employeeDTO.getEmployeeId());
		InfyEmployeeException actual = assertThrows(InfyEmployeeException.class,
				() -> employeeServiceImpl.deleteEmployee(2002));
		assertEquals("Service.EMPLOYEE_NOT_FOUND", actual.getMessage());
	}

}
