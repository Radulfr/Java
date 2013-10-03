package Persistence;

import java.sql.SQLException;
import java.util.LinkedList;

import Dominion.Follows;
import Dominion.User;

public class PruebasDAORRC {
	public static void main (String[] args) throws SQLException{

		CrudDAO<User> c = new UserDAO();
		User a = new User();

		a.setEmail("1@autor.com"); 
		a.setPassword("autor1");
		a = c.read(a); 
		
		
		LinkedList<Follows> l = new LinkedList<Follows>(); 
		
	//	c.create(a);
		
	//	a = c.read(a); 
	//	System.out.println("Done create + read " + a.toString()); 
		
	//	a.setIssue("PTAG");
	//	c.update(a); 
		
//		c.update(a); 
		
//		a.setState("READ");  
	//	l = c.readAll(a); 
		
		System.out.println("Done update + read " + a.toString()); 
		
		//c.delete(a); 
		//System.out.print("Deleted"); 
	}
}
