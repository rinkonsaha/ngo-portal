package com.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IEmployeeDao;
import com.exception.NoSuchEmployeeException;
import com.model.DonationDistribution;
import com.model.Employee;
import com.model.NeedyPeople;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	IEmployeeDao empDao;
	
	

	@Override
	public boolean login(Employee employee) throws NoSuchEmployeeException, SQLException {

		return empDao.login(employee);
	}

	@Override
	public boolean addNeedyPerson(NeedyPeople person) {
		
		return empDao.createNeedyPerson(person);
		
	}

	@Override
	public boolean removeNeedyPerson(NeedyPeople person) {

		return empDao.deleteNeedyPerson(person);
	}

	@Override
	public NeedyPeople findNeedyPeopleById(int id) {

		return null;
	}

	@Override
	public List<NeedyPeople> findNeedyPeopleByName(String name) {
		return empDao.readNeedyPeopleByName(name);
	}

	@Override
	public List<NeedyPeople> findAllNeedyPeople() {

		return empDao.readAllNeedyPeople();
	}

	@Override
	public String helpNeedyPerson(DonationDistribution distribute) {

		return empDao.helpNeedyPerson(distribute);
	}

}
