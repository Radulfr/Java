package Interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

import Dominion.User;

public abstract class AbstractAgentFactory {
	public abstract int createUser(User u) throws SQLException; 
	public abstract int readUser(User u); 
	public abstract int updateUser(User u); 
	public abstract int deleteUser(User u);
	public abstract ResultSet login(User u) throws SQLException ;
	
}
