package com.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.DonationDistribution;
import com.model.Employee;
import com.model.NeedyPeople;

public interface IEmployeeDao extends JpaRepository<Employee, Integer> {

	public boolean login(Employee employee) throws SQLException;

	public boolean createNeedyPerson(NeedyPeople person);

	public boolean deleteNeedyPerson(NeedyPeople person);

	public NeedyPeople readNeedyPeopleById(int id);

	public List<NeedyPeople> readNeedyPeopleByName(String name);

	public List<NeedyPeople> readAllNeedyPeople();

	public String helpNeedyPerson(DonationDistribution distribute);

}
