package Dominion;

import java.sql.SQLException;
import Persistence.*;
import utilidades.leer;

public class Admin extends User {

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String email, String password, String name, String sname,
			String city, String bdate) {
		super(email, password, name, sname, city, bdate);
		// TODO Auto-generated constructor stub
	}

	public Admin(String email) throws SQLException {
		super(email);
		// TODO Auto-generated constructor stub
	}
	public Admin(User u) throws SQLException {
		this.setEmail(u.getEmail());
		this.setName("Admin");
		this.setSecond_name("Admin"); 
		this.setPassword("admin"); 
		this.setCity(u.getCity());
		this.setBirth_date(u.getBirth_date());
		// TODO Auto-generated constructor stub
	}

	public void update_author(Author a) {
		update_generic((User)a); 
		CrudDAO<Author> autordao = new AuthorDAO(); 
		try {
			autordao.update(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public void update_reviewer(Reviewer r) {
		update_generic((User)r);
		CrudDAO<Reviewer> revdao = new ReviewerDAO(); 
		try {
			revdao.update(r);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	public void update_generic(User generic) {
		CrudDAO<User> userdao = new UserDAO(); 
		try {
			userdao.update(generic);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	public void update_publisher(Publisher p) {
		update_generic((User)p); 
		CrudDAO<Publisher> pubdao = new PublisherDAO(); 
		try {
			pubdao.update(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public void manual_Schedule(String field_id, String manual_reviewer) throws SQLException {
		ArticleReview ar = new ArticleReview(); 
		CrudDAO<ArticleReview> ardao = new ArticleReviewDAO(); 
		ar.setState_review("unresolved"); 
		ar.setReview_date(leer.fecha()); 
		ar.setIdArticle(Integer.parseInt(field_id));
		ar.setReviewer_mail(manual_reviewer);
		ar.setComment("No comment"); 
		ar.setMark(-1); 
	
		ardao.create(ar);

	}

}
