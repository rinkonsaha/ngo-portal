package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.DonationDistribution;
import com.model.Employee;

public interface IAdminDao {

	public boolean createEmployee(Employee employee) throws SQLException;

	public Employee updateEmployee(Employee employee) throws SQLException;

	public boolean deleteEmployee(int employeeId) throws SQLException;

	public Employee readEmployeeById(int employeeId) throws SQLException;

	public List<Employee> readEmployeeByName(String name) throws SQLException;

	public List<Employee> readAllEmployees() throws SQLException;

	public boolean approveDonation(DonationDistribution distribution);

}
