package com.service;

import com.dao.INeedyPeopleDao;
import com.model.NeedyPeople;

public class NeedyPeopleServiceImpl implements INeedyPeopleService {
	
	INeedyPeopleDao nDao;

	@Override
	public boolean registerNeedyPerson(NeedyPeople person) {
		return nDao.createNeedyPerson(person);
	}

	@Override
	public boolean login(NeedyPeople person) {
		return nDao.readLoginData(person);
	}

	@Override
	public boolean requestForHelp(NeedyPeople person) {
		return nDao.requestForHelp(person);
	}
	
	

}
