package com.repository;

import com.model.NeedyPeople;

public interface NeedyPeopleRepository {

	public boolean createNeedyPerson(NeedyPeople person);

	public boolean readLoginData(NeedyPeople person);

	public boolean requestForHelp(NeedyPeople person);

}
