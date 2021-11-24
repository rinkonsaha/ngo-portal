package com.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.DuplicateEmployeeException;
import com.exception.NoSuchEmployeeException;
import com.model.Employee;
import com.service.IAdminService;

@RestController
public class AdminController {

	@Autowired
	IAdminService adminService;

	@RequestMapping("/Hello")
	public String helloAdmin() {
		String msg = "Welcome to Admin services";
		return msg;
	}

	// add employee
	@PostMapping("/employee/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
			throws DuplicateEmployeeException, SQLException {
		Employee emp = adminService.addEmployee(employee);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}

	@GetMapping("/employee/get")
	public ResponseEntity<List<Employee>> getEmployees() {
		List<Employee> lcl = adminService.getEmployees();
		ResponseEntity re = new ResponseEntity<List<Employee>>(lcl, HttpStatus.OK);
		return re;
	}

	// modify
	@PutMapping(path = "/employee/update")
	public ResponseEntity<Employee> modifyEmployee(@RequestBody Employee employee) throws Throwable {
		Employee e1 = adminService.modifyEmployee(employee);

		ResponseEntity re = new ResponseEntity<Employee>(e1, HttpStatus.OK);
		return re;
	}

	@DeleteMapping(path = "/employee/remove/{eid}")
	public ResponseEntity<String> removeEmployee(@PathVariable int eid) throws NoSuchEmployeeException {
		adminService.removeEmployee(eid);

		ResponseEntity re = new ResponseEntity<String>("Deleted", HttpStatus.OK);
		return re;
	}

	@GetMapping("/employee/{employeeId}")
	public ResponseEntity<List<Employee>> findEmployeeById(@PathVariable int employeeId)
			throws NoSuchEmployeeException {
		List<Employee> lc = adminService.findEmployeeById(employeeId);
		ResponseEntity re = new ResponseEntity<List<Employee>>(lc, HttpStatus.OK);
		return re;
	}

	@GetMapping("/employee/{employeeName}")
	public ResponseEntity<List<Employee>> findEmployeeByName(@PathVariable String employeeName)
			throws NoSuchEmployeeException {
		List<Employee> lc = adminService.findEmployeeByName(employeeName);
		ResponseEntity re = new ResponseEntity<List<Employee>>(lc, HttpStatus.OK);
		return re;
	}

}
