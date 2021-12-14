package com.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.model.Address;

@Repository
public interface AddressRepository extends JpaRepositoryImplementation<Address, Integer> {

}
