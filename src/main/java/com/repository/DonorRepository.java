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
	
	@Query(value="Select donor_email from donor",nativeQuery = true)
	 String checkIfUserAlreadyExists(String donorEmail);

	 @Query("SELECT donor FROM Donor donor WHERE LOWER(donor.donorEmail) = LOWER(:donorEmail)")
	Donor findByEmailIdIgnoreCase(@Param("donorEmail") String donorEmail);

}
