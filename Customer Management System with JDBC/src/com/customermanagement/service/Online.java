package com.customermanagement.service;

import java.io.IOException;
import java.sql.SQLException;

public interface Online {
	
	public void adddata() throws IOException, ClassNotFoundException, SQLException;
	public void viewdata() throws IOException, ClassNotFoundException, SQLException;
	public void updatedata()throws IOException, ClassNotFoundException,  SQLException;

}
