package com.repository;

import java.sql.SQLException;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Donation;
import com.model.Donor;

public interface DonorRepository extends JpaRepository<Donor,Integer> {

//	public boolean createDonor(Donor donor) throws SQLException;
//
//	public boolean login(Donor donor) throws SQLException;
//
//	public Donation donateToNGO(Donation donation);
//
//	public String forgotPassword(String username);
//
//	public String resetPassword(String username);

}
