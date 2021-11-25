package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.exception.DuplicateEmployeeException;
import com.exception.NoSuchEmployeeException;
import com.model.Address;
import com.model.Employee;
import com.repository.AdminRepository;

@SpringBootTest
class AdminServiceTest {

	@Autowired
	IAdminService adminService;

	@MockBean
	AdminRepository adminRepo;

	@Test
	void testAddEmployee() throws DuplicateEmployeeException, SQLException {
		Employee e = new Employee();
		e.setEmployeeId(1);
		e.setEmployeeName("Rohit");
		e.setPhone("9999999999");
		e.setEmail("abc@gmail.com");
		e.setUsername("rohit");
		e.setPassword("abc123");

		Address a = new Address();
		a.setAddressId(1);
		a.setCity("Noida");
		a.setState("Delhi");
		a.setLandmark("");
		a.setPin("121002");

		e.setAddress(a);
		Mockito.when(adminRepo.save(e)).thenReturn(e);
		assertThat(adminService.addEmployee(e)).isEqualTo(e);
	}

	@Test
	void testGetEmployees() {
		Employee e1 = new Employee();
		e1.setEmployeeId(1);
		e1.setEmployeeName("Rohit");
		e1.setPhone("9999999999");
		e1.setEmail("abc@gmail.com");
		e1.setUsername("rohit");
		e1.setPassword("abc123");

		Address a1 = new Address();
		a1.setAddressId(1);
		a1.setCity("Noida");
		a1.setState("Delhi");
		a1.setLandmark("");
		a1.setPin("121002");

		e1.setAddress(a1);

		Employee e2 = new Employee();
		e2.setEmployeeId(2);
		e2.setEmployeeName("Rahul");
		e2.setPhone("9999955555");
		e2.setEmail("abc1@gmail.com");
		e2.setUsername("rahul");
		e2.setPassword("abc1234");

		Address a2 = new Address();
		a2.setAddressId(2);
		a2.setCity("Kolkata");
		a2.setState("West Bengal");
		a2.setLandmark("");
		a2.setPin("700101");

		e2.setAddress(a2);
		List<Employee> empList = new ArrayList<>();
		empList.add(e1);
		empList.add(e2);

		Mockito.when(adminRepo.findAll()).thenReturn(empList);
		assertThat(adminService.getEmployees()).isEqualTo(empList);
	}
	
	@Test
	void testFindEmployeeById() throws NoSuchEmployeeException {
		Employee e = new Employee();
		e.setEmployeeId(1);
		e.setEmployeeName("Rohit");
		e.setPhone("9999999999");
		e.setEmail("abc@gmail.com");
		e.setUsername("rohit");
		e.setPassword("abc123");

		Address a = new Address();
		a.setAddressId(1);
		a.setCity("Noida");
		a.setState("Delhi");
		a.setLandmark("");
		a.setPin("121002");

		e.setAddress(a);
		Optional<Employee> c2=Optional.of(e);
		Mockito.when(adminRepo.findById(1)).thenReturn(c2);
		assertThat(adminService.findEmployeeById(1)).isEqualTo(e);
	}
	
	@Test
	void testRemoveEmployee() {
		Employee e = new Employee();
		e.setEmployeeId(1);
		e.setEmployeeName("Rohit");
		e.setPhone("9999999999");
		e.setEmail("abc@gmail.com");
		e.setUsername("rohit");
		e.setPassword("abc123");

		Address a = new Address();
		a.setAddressId(1);
		a.setCity("Noida");
		a.setState("Delhi");
		a.setLandmark("");
		a.setPin("121002");

		e.setAddress(a);
		Optional<Employee> c2=Optional.of(e);
		Mockito.when(adminRepo.findById(1)).thenReturn(c2);
		Mockito.when(adminRepo.existsById(e.getEmployeeId())).thenReturn(false);
		assertFalse(adminRepo.existsById(e.getEmployeeId()));
	}
}
