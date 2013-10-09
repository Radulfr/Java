package Dominion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import Interfaces.AbstractAgentFactory;
import Persistence.AgentMySQL;

public class User {
	private int ID; 
	private String email; 
	private String password;
	private String nickname; 
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;

	} 
	public void register(User u) throws SQLException{
		AbstractAgentFactory ag = AgentMySQL.getDbCon();
		ag.createUser(u); 
	}
	public User login(User u) throws SQLException {
		AbstractAgentFactory ag = AgentMySQL.getDbCon();
		User us = null; 
		ResultSet r = ag.login(u);
		while(r.next()){
			us = new User(); 
			us.setID(r.getInt("idUser")); 
			us.setEmail(r.getString("email")); 
			us.setNickname(r.getString("nickname")); 
		}
		return us; 
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}

}
