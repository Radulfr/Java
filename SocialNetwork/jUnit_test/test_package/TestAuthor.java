package test_package;

import java.sql.SQLException;
import java.util.LinkedList;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Dominion.Article;
import Dominion.Author;
import Persistence.AuthorDAO;
import Persistence.CrudDAO;


public class TestAuthor {
	
	private static Author johnDoe=new Author();
	private Article art;
	
    @BeforeClass  
    public static void setUpClass() throws Exception {
    	System.out.println("Ejecutando TestAuthor...");
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
    	System.out.println("Fin TestAuthor");
    }  
      
    @Before  
    public void setUp() {
       	johnDoe = new Author("johnDoe@autor.com", "johnDoe", "John", "Doe", "La solana", "1985-09-09", 0);
       	this.art = new Article("Test title", "2012-10-10", johnDoe.getEmail(), "Test comement", "", -1, "Ejemplo");
    }
      
    @After  
    public void tearDown(){
    	// No Use
    }  
      
    @Test  
    public void sendPublication(){
    	System.out.println("\tTest sendPublication...");
		try {
			LinkedList<Article> preList;
			preList = johnDoe.get_publications();
			Assert.assertEquals(0, preList.size());
			johnDoe.send_publication(art, 0);
			LinkedList<Article> postList = johnDoe.get_publications();
			Assert.assertEquals(1, postList.size());
		} catch (Exception e) {
			Assert.fail(e.toString());
		}
    }
    
    @Test  
    public void cancelPublication() throws SQLException {
    	System.out.println("\tTest cancelPublication...");
    	try{
//	    	LinkedList<Article> preList = johnDoe.get_publications();
//	    	johnDoe.cancel_review(preList.getFirst().getId());
//	    	Article car = new Article(preList.getFirst().getId());
//	    	Assert.assertEquals("Cancelled", car.getState());
	    	LinkedList<Article> preList = johnDoe.get_publications();
	    	johnDoe.cancel_review(preList.getFirst().getId());
	    	LinkedList<Article> postList = johnDoe.get_publications();
	    	Article cancelled = new Article(postList.getFirst().getId());
	    	Assert.assertEquals("cancelled", cancelled.getState());
    	}catch(Exception e){
    		Assert.fail(e.toString());
    	}
    }
    
}
