package com.service;

import java.sql.SQLException;
import java.util.List;

import com.exception.DuplicateEmployeeException;
import com.exception.NoSuchEmployeeException;
import com.model.DonationDistribution;
import com.model.Employee;

public interface IAdminService {

	public boolean addEmployee(Employee employee) throws DuplicateEmployeeException, SQLException;

	public Employee modifyEmployee(Employee employee) throws NoSuchEmployeeException, SQLException;

	public boolean removeEmployee(int employeeId) throws NoSuchEmployeeException, SQLException;

	public Employee findEmployeeById(int employeeId) throws NoSuchEmployeeException, SQLException;

	public List<Employee> findEmployeeByName(String name) throws NoSuchEmployeeException, SQLException;

	public List<Employee> findAllEmployee() throws NoSuchEmployeeException, SQLException;

	public boolean approveDonation(DonationDistribution distribution);

}
