package com.exception;

public class DuplicateEmployeeException extends Exception {
	
	public DuplicateEmployeeException() {}
	public DuplicateEmployeeException(String emp) 
	{
		super(emp);
	}

}
