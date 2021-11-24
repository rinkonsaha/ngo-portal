package com.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.exception.DuplicateEmployeeException;
import com.exception.NoSuchEmployeeException;
import com.model.DonationDistribution;
import com.model.Employee;

@Service
public interface IAdminService {

	public Employee addEmployee(Employee employee) throws DuplicateEmployeeException, SQLException;

	public Employee modifyEmployee(Employee employee) throws NoSuchEmployeeException, Throwable;

	public String removeEmployee(int employeeId) throws NoSuchEmployeeException;

	public List<Employee> findEmployeeById(int employeeId) throws NoSuchEmployeeException;

	public List<Employee> findEmployeeByName(String name) throws NoSuchEmployeeException;

	public List<Employee> findAllEmployee() throws NoSuchEmployeeException;

	public boolean approveDonation(DonationDistribution distribution);

	List<Employee> getEmployees();

}
