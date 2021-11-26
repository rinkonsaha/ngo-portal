package com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.NoSuchNeedyPeopleException;
import com.model.NeedyPeople;
import com.service.NeedyPeopleServiceImpl;

@RestController
@RequestMapping("/needyPeople")
public class NeedyPeopleController {

	static final Logger LOGGER = LoggerFactory.getLogger(NeedyPeopleController.class);
	@Autowired
	NeedyPeopleServiceImpl needyImpl;
	
	
	
	@PostMapping("/login/add")
    public  ResponseEntity<NeedyPeople> registerNeedyPerson(@RequestBody NeedyPeople person) throws NoSuchNeedyPeopleException{
        LOGGER.info("add-user URL is opened");
        LOGGER.info("registerNeedyPerson() is initiated");
        NeedyPeople p = needyImpl.registerNeedyPerson(person);
        LOGGER.info("registerNeedyPerson() has executed");
        return new ResponseEntity<NeedyPeople>(person,HttpStatus.CREATED);
    }
}