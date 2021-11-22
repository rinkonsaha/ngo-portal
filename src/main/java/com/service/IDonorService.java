package com.service;

import java.sql.SQLException;

import com.exception.DuplicateDonorException;
import com.exception.NoSuchDonorException;
import com.model.Donation;
import com.model.Donor;

public interface IDonorService {

	public boolean registerDonor(Donor donor) throws DuplicateDonorException, SQLException;

	public boolean login(Donor donor) throws NoSuchDonorException, SQLException;

	public Donation donateToNGO(Donation donation);

	public void sendThankyouMailToDonator(Donor donor);

	public String forgotPassword(String username);

	public String resetPassword(String username);

	public void emailPasswordToDonor(String email);

}
