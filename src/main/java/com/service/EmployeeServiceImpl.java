package com.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.NoSuchDonorException;
import com.exception.NoSuchEmployeeException;
import com.model.DonationDistribution;
import com.model.Donor;
import com.model.Employee;
import com.model.NeedyPeople;
import com.repository.AdminRepository;
import com.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private AdminRepository adminRepo;

	@Override
	public Employee login(Employee employee) throws NoSuchEmployeeException, SQLException {
		Employee emp=adminRepo.findById(employee.getEmployeeId()).orElse(null);
		if(emp==null) {
			String noSuchEmployee="No Donor found by the donor id"+employee.getEmployeeId();
			throw new  NoSuchEmployeeException(noSuchEmployee);
		}
		else {
			if(employee.getUsername().equals(emp.getUsername()) && employee.getPassword().equals(emp.getPassword())){
				return emp;
			}
			else {
				throw new NoSuchEmployeeException("Employee username and password are invalid");
			}
		}	
	}

	@Override
	public NeedyPeople addNeedyPerson(NeedyPeople person) {
		empRepo.save(person);
		return person;

	}

	@Override
	public void removeNeedyPerson(NeedyPeople person) {
		empRepo.delete(person);
		// return empDao.deleteNeedyPerson(person);
	}

	@Override
	public NeedyPeople findNeedyPeopleById(int id) {

		return empRepo.findById(id).get();
	}

	@Override
	public List<NeedyPeople> findAllNeedyPeople() {
		return empRepo.findAll();
	}

	/*
	 * @Override public String helpNeedyPerson(DonationDistribution distribute) {
	 * return empDao.helpNeedyPerson(distribute); }
	 */

}
