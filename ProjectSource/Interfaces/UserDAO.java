package Interfaces;

import Dominion.User;

public interface UserDAO {
	public int Create(User u); 
	public int Read(User u);
	public int Update(User u); 
	public int Delete(User u); 

}
