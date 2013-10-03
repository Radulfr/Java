package test_package;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Dominion.Author;
import Dominion.User;
import Persistence.AuthorDAO;
import Persistence.CrudDAO;

public class TestNewPassword {
	
	private static Author johnDoe;
	private User us;
	
    @BeforeClass  
    public static void setUpClass() throws Exception {
    	System.out.println("Ejecutando TestNewPassword...");
    	try{
    		johnDoe = new Author("johnDoe@autor.com", "johnDoe", "John", "Doe", "La solana", "1985-09-09", 0);
    		CrudDAO<Author> DAO_au = new AuthorDAO();
    		DAO_au.create(johnDoe);
    	}catch(Exception e){
    		Assert.fail(e.toString());
    	}
    }  
      
    @AfterClass  
    public static void tearDownClass() throws Exception {  
    	try{
    		CrudDAO<Author> DAO_au = new AuthorDAO();
    		DAO_au.delete(johnDoe);
    	}catch(Exception e){
    		Assert.fail(e.toString());
    	}
    	System.out.println("Fin TestNewPassword");
    }  
      
    @Before  
    public void setUp() {
    	this.us = null;
    }
      
    @After  
    public void tearDown(){
    	this.us = null;
    }  
      
    @Test  
    public void newPassword(){
    	System.out.println("\tTest newPassword...");
		try {
			this.us = new User(johnDoe.getEmail());
			String newPass = "newPassword";
			this.us.setPassword(newPass);
			this.us.edit_profile(this.us);
			Assert.assertEquals(newPass, this.us.getPassword());
		} catch (Exception e) {
			Assert.fail(e.toString());
		}
    }    
}
