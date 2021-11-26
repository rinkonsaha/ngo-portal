package com.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.DuplicateEmployeeException;
import com.exception.NoSuchEmployeeException;
import com.model.DonationDistribution;
import com.model.Employee;
import com.repository.AdminRepository;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	AdminRepository adminRepo;

	Employee emp;

	@Override
	public Employee addEmployee(Employee employee) throws DuplicateEmployeeException, SQLException {
		int id = employee.getEmployeeId();
		if (id == 0) {
			throw new DuplicateEmployeeException();
		} else {
			emp = adminRepo.save(employee);
		}
		return emp;
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> lc1 = adminRepo.findAll();

		return lc1;
	}

	@Override
	public Employee modifyEmployee(Employee employee) throws Throwable {
		int id = employee.getEmployeeId();
		Supplier s1 = () -> new NoSuchEmployeeException("Employee Does not exist in the database");
		@SuppressWarnings("unchecked")
		Employee emp = adminRepo.findById(id).orElseThrow(s1);

		emp.setEmployeeName(emp.getEmployeeName());
		emp.setPhone(emp.getPhone());
		adminRepo.save(emp);

		return emp;

	}

	@Override
	public String removeEmployee(int employeeId) throws NoSuchEmployeeException {
		if (employeeId != 0)
			adminRepo.deleteById(employeeId);

		else
			throw new NoSuchEmployeeException("Employee is not there in database");
		return "deleted";

	}

	@Override
	public Employee findEmployeeById(int employeeId) throws NoSuchEmployeeException {
		Optional<Employee> optional = adminRepo.findById(employeeId);
		Employee emp = optional.get();
		if (optional.isPresent()) {
			adminRepo.getById(employeeId);
			return emp;
		} else
			throw new NoSuchEmployeeException("No Such Employee Found");

	}

	@Override
	public List<Employee> findEmployeeByName(String name) throws NoSuchEmployeeException {

		return adminRepo.findmployeeByName(name);

	}

	@Override
	public List<Employee> findAllEmployee() throws NoSuchEmployeeException {

		return adminRepo.findAll();
	}

	@Override
	public boolean approveDonation(DonationDistribution distribution) {
		System.out.println("donation was approved");
		return false;
	}

}
