package com.service;

import org.springframework.stereotype.Service;

import com.model.Address;

@Service
public interface IAddressService {
	
	//public Address addAddress(Address address);
	public Address getNeedyPeopleAddress(int addressId);
}
