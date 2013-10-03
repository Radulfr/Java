package test_package;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Dominion.Author;
import Dominion.Publisher;
import Dominion.Reviewer;
import Dominion.User;
import Persistence.AuthorDAO;
import Persistence.CrudDAO;
import Persistence.PublisherDAO;
import Persistence.ReviewerDAO;

public class TestLogin {
	
	private static Author johnDoe;
	private static Reviewer janeDoe;
	private static Publisher johnSmith;
	private User us = null;
	
    @BeforeClass  
    public static void setUpClass() throws Exception {
    	System.out.println("Ejecutando TestLogin...");
    	try{
    		johnDoe = new Author("johnDoe@autor.com", "johnDoe", "John", "Doe", "La solana", "1985-09-09", 0);
    		janeDoe = new Reviewer("janeDoe@revisor.com", "janeDoe", "jane", "Doe", "La Solana", "1985-04-04", 0, 0);
    		johnSmith = new Publisher("johnSmith@publisher.com", "johnSmith", "john", "Smith", "La Solana", "1985-01-01", "Revistita", "www.resvistita.com");
    		
    		CrudDAO<Author> DAO_au = new AuthorDAO();
    		DAO_au.create(johnDoe);
    		CrudDAO<Reviewer> DAO_re = new ReviewerDAO();
    		DAO_re.create(janeDoe);
    		CrudDAO<Publisher> DAO_pu = new PublisherDAO();
    		DAO_pu.create(johnSmith);
    	}catch(Exception e){
    		Assert.fail(e.toString());
    	}
    }  
      
    @AfterClass  
    public static void tearDownClass() throws Exception {  
    	try{
    		CrudDAO<Author> DAO_au = new AuthorDAO();
    		DAO_au.delete(johnDoe);
    		CrudDAO<Reviewer> DAO_re = new ReviewerDAO();
    		DAO_re.delete(janeDoe);
    		CrudDAO<Publisher> DAO_pu = new PublisherDAO();
    		DAO_pu.delete(johnSmith);
    	}catch(Exception e){
    		Assert.fail(e.toString());
    	}
    	System.out.println("Fin TestLogin");
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
    public void loginAutor(){
    	System.out.println("\tTest loginAutor...");
		try {
			this.us = new User(johnDoe.getEmail());
			String mail = "johnDoe@autor.com";
			String pass = "johnDoe";
			this.us = this.us.log(mail, pass);
			Assert.assertNotNull(this.us);
		} catch (Exception e) {
			Assert.fail(e.toString());
		}
    }
    
    @Test  
    public void notLoginAutor(){
    	System.out.println("\tTest notLoginAutor...");
		try {
			this.us = new User(johnDoe.getEmail());
			String mail = "johnDoe@autor.com";
			String pass = "any";
			this.us = this.us.log(mail, pass);
			Assert.assertNull(this.us);
		} catch (Exception e) {
			Assert.fail(e.toString());
		}
    }
    
    @Test  
    public void loginRevisor(){
    	System.out.println("\tTest loginRevisor...");
		try {
			this.us = new User(janeDoe.getEmail());
			String mail = "janeDoe@revisor.com";
			String pass = "janeDoe";
			this.us = this.us.log(mail, pass);
			Assert.assertNotNull(this.us);
		} catch (Exception e) {
			Assert.fail(e.toString());
		}
    }
    
    @Test  
    public void notLoginRevisor(){
    	System.out.println("\tTest notLoginRevisor...");
		try {
			this.us = new User(janeDoe.getEmail());
			String mail = "janeDoe@revisor.com";
			String pass = "000any";
			this.us = this.us.log(mail, pass);
			Assert.assertNull(this.us);
		} catch (Exception e) {
			Assert.fail(e.toString());
		}
    }
    
    @Test  
    public void loginEditor(){
    	System.out.println("\tTest loginEditor...");
		try {
			this.us = new User(johnSmith.getEmail());
			String mail = "johnSmith@Publisher.com";
			String pass = "johnSmith";
			this.us = this.us.log(mail, pass);
			Assert.assertNotNull(this.us);
		} catch (Exception e) {
			Assert.fail(e.toString());
		}
    }
    
    @Test  
    public void notLoginEditor(){
    	System.out.println("\tTest notLoginEditor...");
		try {
			this.us = new User(johnSmith.getEmail());
			String mail = "johnSmith@Publisher.com";
			String pass = "lastAny";
			this.us = this.us.log(mail, pass);
			Assert.assertNull(this.us);
		} catch (Exception e) {
			Assert.fail(e.toString());
		}
    }
    
    @Test
    public void loginInCapitals(){
    	System.out.println("\tTest loginInCapitals");
    	try{
    		this.us = new User(johnDoe.getEmail());
    		String mail = "johnDoe@autor.com";
    		String pass = "johnDoe";
    		this.us = this.us.log(mail, pass.toUpperCase());
    		Assert.assertNull(this.us);
    	}catch(Exception e){
    		Assert.fail("No se esperaba la exception");
    	}
    }
    
    @Test
    public void loginInLowers(){
    	System.out.println("\tTest loginInLowers");
    	try{
    		this.us = new User(janeDoe.getEmail());
    		String mail = "janeDoe@revisor.com";
    		String pass = "janeDoe";
    		this.us = this.us.log(mail, pass.toLowerCase());
    		Assert.assertNull(this.us);
    	}catch(Exception e){
    		Assert.fail(e.toString());
    	}
    }
    
    @Test  
    public void loginNoPass(){
    	System.out.println("\tTest loginNoPass...");
		try {
			this.us = new User(johnDoe.getEmail());
			String mail = "johnDoe@autor.com";
			String pass = "";
			this.us = this.us.log(mail, pass);
			Assert.assertNull(this.us);
		} catch (Exception e) {
			Assert.fail(e.toString());
		}
    }
}
