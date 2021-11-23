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
	private IEmployeeDao empDao;

	@Override
	public boolean login(Employee employee) throws NoSuchEmployeeException, SQLException {
		return empDao.login(employee);
	}

	@Override
	public NeedyPeople addNeedyPerson(NeedyPeople person) {
		empDao.save(person);
		return person;
		
	}

	@Override
	public void removeNeedyPerson(NeedyPeople person) {
		empDao.delete(person);
		//return empDao.deleteNeedyPerson(person);
	}

	@Override
	public NeedyPeople findNeedyPeopleById(int id) {

		return empDao.findById(id).get();
	}

	@Override
	public List<NeedyPeople> findNeedyPeopleByName(String name) {
		return empDao.readNeedyPeopleByName(name);
	}

	@Override
	public List<NeedyPeople> findAllNeedyPeople() {
		return empDao.findAll();
	}

	@Override
	public String helpNeedyPerson(DonationDistribution distribute) {
		return empDao.helpNeedyPerson(distribute);
	}

}
