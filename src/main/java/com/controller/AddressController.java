package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.model.Address;
import com.service.AddressServiceImpl;

@RestController
@CrossOrigin
public class AddressController {
	
	@Autowired
	AddressServiceImpl addressService;

	// get needy people address
	@GetMapping("/needy/address/{addressId}")
	public ResponseEntity<Address> getNeedyPeopleAddress(@PathVariable int addressId) {
		Address lcl = addressService.getNeedyPeopleAddress(addressId);
		ResponseEntity<Address> re = new ResponseEntity<Address>(lcl, HttpStatus.OK);
		return re;
	}

}
