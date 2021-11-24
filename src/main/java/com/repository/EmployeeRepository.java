package com.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.DonationDistribution;
import com.model.Employee;
import com.model.NeedyPeople;

@Repository
public interface EmployeeRepository extends JpaRepository<NeedyPeople, Integer> {

	//public boolean login(Employee employee) throws SQLException;

	//public boolean createNeedyPerson(NeedyPeople person);

	//public boolean deleteNeedyPerson(NeedyPeople person);

	//public NeedyPeople readNeedyPeopleById(int id);

	//public List<NeedyPeople> readNeedyPeopleByName(String name);

	//public List<NeedyPeople> readAllNeedyPeople();

	//public String helpNeedyPerson(DonationDistribution distribute);

}
