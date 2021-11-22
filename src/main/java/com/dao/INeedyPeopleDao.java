package com.dao;

import com.model.NeedyPeople;

public interface INeedyPeopleDao {

	public boolean createNeedyPerson(NeedyPeople person);

	public boolean readLoginData(NeedyPeople person);

	public boolean requestForHelp(NeedyPeople person);

}
