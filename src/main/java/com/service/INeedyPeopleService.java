package com.service;

import com.model.NeedyPeople;

public interface INeedyPeopleService {

	public boolean registerNeedyPerson(NeedyPeople person);

	public boolean login(NeedyPeople person);

	public boolean requestForHelp(NeedyPeople person);

}
