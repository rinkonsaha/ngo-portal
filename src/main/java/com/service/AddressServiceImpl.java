package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Address;
import com.repository.AddressRepository;

@Service
public class AddressServiceImpl implements IAddressService {
	
	@Autowired
	AddressRepository addRepo;

	@Override
	public Address getNeedyPeopleAddress(int addressId) {
		Optional<Address> e = addRepo.findById(addressId);
		return e.get();
	}

}
