package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.exception.NoSuchNeedyPeopleException;
import com.model.Address;
import com.model.NeedyPeople;
import com.repository.NeedyPeopleRepository;

@SpringBootTest
class NeedyPeopleServiceTest {

	@MockBean
	NeedyPeopleRepository needyRepo;
	
	@Autowired
	INeedyPeopleService needyService;
	
	@Test
	@Disabled
	void testRegisterNeedyPerson() throws NoSuchNeedyPeopleException {
		NeedyPeople p=new NeedyPeople();
		p.setNeedyPersonId(1);
		p.setNeedyPersonName("mamatha");
		p.setPhone("345678");
		p.setFamilyIncome(5000);
		//p.setAddress(null);
		Address a=new Address();
		a.setAddressId(1);
		a.setCity("Noida");
		a.setState("Delhi");
		a.setLandmark("");
		a.setPin("121002");
		//p.setAddress(a);
		Mockito.when(needyRepo.save(p)).thenReturn(p);
		assertThat(needyService.registerNeedyPerson(p)).isEqualTo(p);
	}
	

}
