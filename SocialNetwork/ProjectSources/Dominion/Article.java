package Dominion;

import java.sql.SQLException;
import java.util.LinkedList;

import Persistence.ArticleDAO;
import Persistence.ArticleReviewDAO;
import Persistence.CrudDAO;

public class Article {

	private int id;
	private String title;
	private String publishing_date;
	private String id_author;
	private String comment_author;
	private String state;
	private int mark;
	private String body;

	
	public Article(String title, String publishing_date, String id_author,
			String comment_author, String state, int mark, String body) {
		this.title = title;
		this.publishing_date = publishing_date;
		this.id_author = id_author;
		this.comment_author = comment_author;
		this.state = state;
		this.mark = mark;
		this.body=body;
	}
	
	public Article(int idArt) throws SQLException{
		this.id=idArt;
		CrudDAO<Article> c = new ArticleDAO();
		Article a=c.read(this);
		this.title = a.getTitle();
		this.publishing_date = a.getPublishing_date();
		this.id_author = a.getId_author();
		this.comment_author = a.getComment_author();
		this.state = a.getState();
		this.mark = a.getMark();
		this.body= a.getBody();
	}
	
	public Article(){
		this.id=0; 
	}

	
	public int getId() {
		return id;
	}
	
	public void setId(int i){
		id=i;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublishing_date() {
		return publishing_date;
	}
	public void setPublishing_date(String publishing_date) {
		this.publishing_date = publishing_date;
	}
	public String getId_author() {
		return id_author;
	}
	public void setId_author(String id_author) {
		this.id_author = id_author;
	}
	public String getComment_author() {
		return comment_author;
	}
	public void setComment_author(String comment_author) {
		this.comment_author = comment_author;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark){
		this.mark=mark;
	}
	
	public void setMark() throws SQLException {
		//Calcula la media de las revisiones para calcular la nota final
		CrudDAO<ArticleReview> c = new ArticleReviewDAO();
		ArticleReview ar = new ArticleReview();
		ar.setIdArticle(this.id);
		ar.setMark(0);
		LinkedList<ArticleReview> lartrev = c.readAll(ar);
		this.mark=media(lartrev);
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	
	/**
	 * @author roske
	 * @desc Finds all articles not reviewed (state=Creado)
	 * @return LinkedList<Article>
	 * @throws SQLException
	 */
	public LinkedList<Article> getArticlesNotReviewed() throws SQLException{
		CrudDAO<Article> c = new ArticleDAO();
		Article articulo= new Article();
		articulo.setState("sent");
		LinkedList<Article> l = c.readAll(articulo);
		
		Article articulo2= new Article();
		articulo2.setState("halfreviewed");
		LinkedList<Article> l2 = c.readAll(articulo2);
		
		Article articulo3= new Article();
		articulo3.setState("reviewed");
		LinkedList<Article> l3 = c.readAll(articulo3);
		
		Article articulo4= new Article();
		articulo4.setState("cancelled");
		LinkedList<Article> l4 = c.readAll(articulo4);
		
		l.addAll(l2);
		l.addAll(l3);
		l.addAll(l4);
		
		return l;
	}
	
	/**
	 * @author roske
	 * @desc Finds all articles
	 * @return LinkedList<Article>
	 * @throws SQLException
	 */
	public LinkedList<Article> getAllArticles() throws SQLException{
		CrudDAO<Article> c = new ArticleDAO();
		Article articulo= new Article();
		LinkedList<Article> l = c.readAll(articulo);
		return l;
	}
	
	
	@Override
	public String toString() {
		return "Article [idArticle=" + id + ", title=" + title + ", publishing_date="
				+ publishing_date + ", id_author=" + id_author
				+ ", comment_author=" + comment_author + ", state=" + state
				+ ", mark=" + mark + ", body= "+ body + "]\n";
	}
	
	private int media (LinkedList<ArticleReview> l ){
		int m=0;
		for (int i=0; i<=l.size();i++){
			m+=l.get(i).getMark();			
		}
		m=(int)m/l.size();
		return m;
	}
		
}
