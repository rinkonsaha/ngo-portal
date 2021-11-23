package com.service;

import java.sql.SQLException;
import java.util.List;

import com.exception.NoSuchEmployeeException;
import com.model.DonationDistribution;
import com.model.Employee;
import com.model.NeedyPeople;

public interface IEmployeeService {

	//public boolean login(Employee employee) throws NoSuchEmployeeException, SQLException;

	public NeedyPeople addNeedyPerson(NeedyPeople person);

	public void removeNeedyPerson(NeedyPeople person);

	public NeedyPeople findNeedyPeopleById(int id);

	//public List<NeedyPeople> findNeedyPeopleByName(String name);

	public List<NeedyPeople> findAllNeedyPeople();

	//public String helpNeedyPerson(DonationDistribution distribute);

}
