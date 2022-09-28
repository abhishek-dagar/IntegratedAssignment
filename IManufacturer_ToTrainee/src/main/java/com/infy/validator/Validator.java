package com.infy.validator;

import com.infy.dto.EmployeeDTO;
import com.infy.exception.InfyEmployeeException;

public class Validator {
	
	public static void validate(EmployeeDTO employee) throws InfyEmployeeException	{
		if(!validateEmailId(employee.getEmailId())){
			throw new InfyEmployeeException("Validator.INVALID_EMAIL_ID");
		}
	}
	
	public static Boolean validateEmailId(String emailId)	{
		return emailId.matches("[\\w]+@[a-zA-Z]+\\.[a-zA-Z]+");
	}

}
