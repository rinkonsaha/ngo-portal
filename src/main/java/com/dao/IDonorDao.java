package com.dao;

import java.sql.SQLException;

import com.model.Donation;
import com.model.Donor;

public interface IDonorDao {

	public boolean createDonor(Donor donor) throws SQLException;

	public boolean login(Donor donor) throws SQLException;

	public Donation donateToNGO(Donation donation);

	public String forgotPassword(String username);

	public String resetPassword(String username);

}