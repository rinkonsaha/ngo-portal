package com.repository;

import java.sql.SQLException;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.Donation;
import com.model.Donor;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Integer> {
	@Query(value="select count(d.donor_email)from donor d having count(d.donor_email)<=1",nativeQuery=true)
	String checkIfUserAlreadyExists(String donorEmail);

}
