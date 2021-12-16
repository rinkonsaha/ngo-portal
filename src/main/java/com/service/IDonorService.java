package com.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.exception.DuplicateDonorException;
import com.exception.NoSuchDonorException;
import com.model.Donation;
import com.model.Donor;

@Service
public interface IDonorService {

	public Donor registerDonor(Donor donor) throws DuplicateDonorException, SQLException;
	public Donor modifyDonor(int donorId, Donor donor) throws DuplicateDonorException, Throwable;
	
	public List<Donor> getDonors();
	public Donor login(Donor donor) throws NoSuchDonorException;
	public Donation donateToNGO(Donation donation);
	public void sendThankyouMailToDonator(Donor donor);
	public String forgotPassword(String username,String password);
	
	public void emailPasswordToDonor(String email);
	public String resetPassword(String username, String password);
	public Donor removeDonor(int donorId) throws NoSuchDonorException;

}
