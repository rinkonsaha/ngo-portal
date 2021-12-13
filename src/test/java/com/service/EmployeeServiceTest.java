package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.model.Address;
import com.model.NeedyPeople;
import com.repository.EmployeeRepository;

@SpringBootTest
class EmployeeServiceTest {
	
	@Autowired
	IEmployeeService empService;
	
	@MockBean
	EmployeeRepository empRepo;

	@Test
	void testAddNeedyPerson() {
		NeedyPeople p=new NeedyPeople();
		p.setNeedyPersonId(1);
		p.setNeedyPersonName("Rakesh");
		p.setPhone("9999999999");
		p.setFamilyIncome(5000.0);
//		Address a=new Address();
//		a.setAddressId(1);
//		a.setCity("Noida");
//		a.setState("Delhi");
//		a.setLandmark("");
//		a.setPin("121002");
//		p.setAddress(a);
		Mockito.when(empRepo.save(p)).thenReturn(p);
		assertThat(empService.addNeedyPerson(p)).isEqualTo(p);
	}

	@Test
	void testRemoveNeedyPerson() {
		
		NeedyPeople p=new NeedyPeople();
		p.setNeedyPersonId(1);
		p.setNeedyPersonName("Rakesh");
		p.setPhone("9999999999");
		p.setFamilyIncome(5000.0);
//		Address a=new Address();
//		a.setAddressId(1);
//		a.setCity("Noida");
//		a.setState("Delhi");
//		a.setLandmark("");
//		a.setPin("121002");
//		p.setAddress(a);
		Optional<NeedyPeople> p1=Optional.of(p);
		Mockito.when(empRepo.findById(1)).thenReturn(p1);
		Mockito.when(empRepo.existsById(p.getNeedyPersonId())).thenReturn(false);
		assertFalse(empRepo.existsById(p.getNeedyPersonId()));
	}

	@Test
	void testFindNeedyPeopleById() {
		NeedyPeople p=new NeedyPeople();
		p.setNeedyPersonId(1);
		p.setNeedyPersonName("Rakesh");
		p.setPhone("9999999999");
		p.setFamilyIncome(5000.0);
//		Address a=new Address();
//		a.setAddressId(1);
//		a.setCity("Noida");
//		a.setState("Delhi");
//		a.setLandmark("");
//		a.setPin("121002");
//		p.setAddress(a);
		Optional<NeedyPeople> p1=Optional.of(p);
		Mockito.when(empRepo.findById(1)).thenReturn(p1);
		assertThat(empService.findNeedyPeopleById(1)).isEqualTo(p);
	}

	@Test
	void testFindAllNeedyPeople() {
		NeedyPeople p1=new NeedyPeople();
		p1.setNeedyPersonId(1);
		p1.setNeedyPersonName("Rakesh");
		p1.setPhone("9999999999");
		p1.setFamilyIncome(5000.0);
//		Address a1=new Address();
//		a1.setAddressId(1);
//		a1.setCity("Noida");
//		a1.setState("Delhi");
//		a1.setLandmark("");
//		a1.setPin("121002");
//		p1.setAddress(a1);
		
		NeedyPeople p2=new NeedyPeople();
		p2.setNeedyPersonId(2);
		p2.setNeedyPersonName("Rahul");
		p2.setPhone("9999988888");
		p2.setFamilyIncome(9000.0);
//		Address a2=new Address();
//		a2.setAddressId(2);
//		a2.setCity("Kolkata");
//		a2.setState("West Bengal");
//		a2.setLandmark("");
//		a2.setPin("700101");
//		p2.setAddress(a2);
		
		List<NeedyPeople> l=new ArrayList<>();
		l.add(p1);
		l.add(p2);
		
		Mockito.when(empRepo.findAll()).thenReturn(l);
		assertThat(empService.findAllNeedyPeople()).isEqualTo(l);
	}

}
