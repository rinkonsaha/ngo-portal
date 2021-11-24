package com.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.model.DonationDistribution;
import com.model.Employee;

@Repository
public interface AdminRepository extends JpaRepository<Employee,Integer>{

	//public boolean createEmployee(Employee employee) throws SQLException;

	//public Employee updateEmployee(Employee employee) throws SQLException;

	//public boolean deleteEmployee(int employeeId) throws SQLException;

	//public Employee readEmployeeById(int employeeId) throws SQLException;

	@Query(value="SELECT  employee FROM Employee employee where employee.employee_name like : ",nativeQuery = true)
	List<Employee> findmployeeByName(String name);

	//public List<Employee> readAllEmployees() throws SQLException;

	//public boolean approveDonation(DonationDistribution distribution);

}
