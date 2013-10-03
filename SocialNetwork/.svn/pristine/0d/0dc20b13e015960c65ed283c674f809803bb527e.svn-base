package test_package;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Dominion.Article;
import Dominion.ArticleReview;
import Dominion.Author;
import Dominion.Reviewer;
import Dominion.ReviewerTag;
import Dominion.Sistema;
import Dominion.Tag;
import Persistence.ArticleDAO;
import Persistence.AuthorDAO;
import Persistence.CrudDAO;
import Persistence.ReviewerDAO;
import Persistence.ReviewerTagDAO;
import Persistence.TagDAO;

public class TestSistema {
	
	private static Author johnDoe;
	private static Reviewer janeDoe, johnSmith;
	private static Tag testTag = new Tag();
	private static ReviewerTag janeTag, johnTag;
	private Article art;
	
    @BeforeClass  
    public static void setUpClass() throws Exception {
    	System.out.println("Ejecutando TestSistema...");
    	try{
    		johnDoe = new Author("johnDoe@autor.com", "johnDoe", "John", "Doe", "La solana", "1985-09-09", 0);
    		janeDoe = new Reviewer("janeDoe@revisor.com", "janeDoe", "jane", "Doe", "La Solana", "1985-04-04", 0, 0);
    		johnSmith = new Reviewer("johnSmith@publisher.com", "johnSmith", "john", "Smith", "La Solana", "1985-01-01", 0, 0);
    		
    		CrudDAO<Author> DAO_au = new AuthorDAO();
    		DAO_au.create(johnDoe);
    		CrudDAO<Reviewer> DAO_re = new ReviewerDAO();
    		DAO_re.create(janeDoe);
    		DAO_re.create(johnSmith);
    		
    		testTag.setIssue("TESTER");
    		CrudDAO<Tag> DAO_tag = new TagDAO();
    		DAO_tag.create(testTag);
    		testTag = new Tag(testTag.getIssue());
    		
    		janeTag = new ReviewerTag(janeDoe.getEmail(), testTag.getIdTag());
    		johnTag = new ReviewerTag(johnSmith.getEmail(), testTag.getIdTag());
    		CrudDAO<ReviewerTag> DAO_rt = new ReviewerTagDAO();
    		DAO_rt.create(janeTag);
    		DAO_rt.create(johnTag);
    		
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
    		DAO_re.delete(johnSmith);
    		CrudDAO<Tag> DAO_tag = new TagDAO();
    		DAO_tag.delete(testTag);
    	}catch(Exception e){
    		Assert.fail(e.toString());
    	}
    	System.out.println("Fin TestSistema");
    }  
      
    @Before  
    public void setUp(){
    	this.art = new Article("Test title", "2012-10-10", johnDoe.getEmail(), "Test comement", "", -1,"Ejemplo");
    }  
      
    @After  
    public void tearDown(){
    	try {
    		CrudDAO<Article> DAO_art = new ArticleDAO();
        	DAO_art.delete(this.art);
		} catch(Exception e){
			Assert.fail(e.toString());
		}
    	
    }
      
    @Test
    public void publicationsTo2Reviewer(){
    	System.out.println("\tTest publicationsTo2Reviewer...");
    	try{
    		johnDoe.send_publication(this.art, 0);
    		johnDoe.set_articleTag(art, testTag.getIssue());
    		Sistema s = new Sistema(johnDoe);
    		s.PublicationsToReviewer(johnDoe, this.art, testTag.getIdTag());
	    	ArticleReview jane_ar = new ArticleReview(this.art.getId(), janeDoe.getEmail());
	    	ArticleReview john_ar = new ArticleReview(this.art.getId(), johnSmith.getEmail());
	    	Assert.assertNotNull(jane_ar);
	    	Assert.assertNotNull(john_ar);
    	}catch(Exception e){
    		Assert.fail(e.toString());
    	}
    }   
    
}
