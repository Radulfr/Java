package Dominion;

import java.sql.SQLException;

import Persistence.ArticleReviewDAO;
import Persistence.CrudDAO;

public class ArticleReview {
	
	private int idArticle;
	private String reviewer_mail;
	private String comment;
	private String review_date;
	private String state_review;
	private int mark;
	
	public ArticleReview(int id, String rev_mail, String comment, String rev_date, String state_rev, int mark){
		this.idArticle = id;
		this.reviewer_mail = rev_mail;
		this.comment = comment;
		this.review_date = rev_date;
		this.state_review=state_rev;
		this.mark=mark;
	}
	
	public ArticleReview(){
		this.mark=-1;
	}
	
	public ArticleReview(int idArticle, String reviewerMail) throws SQLException{
		this.idArticle=idArticle;
		this.reviewer_mail=reviewerMail;
		CrudDAO<ArticleReview> c = new ArticleReviewDAO();
		ArticleReview ar=c.read(this);
		this.comment = ar.getComment();
		this.review_date = ar.getReview_date();
		this.state_review = ar.getState_review();
		this.mark = ar.getMark();
	}

	
	//GETS
	public int getIdArticle() {
		return idArticle;
	}	
	public String getReviewer_mail() {
		return reviewer_mail;
	}
	public String getComment() {
		return comment;
	}	
	public String getReview_date() {
		return review_date;
	}
	public String getState_review(){
		return state_review;
	}
	public int getMark(){
		return mark;
	}
	
	//SETS
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}	
	public void setReviewer_mail(String reviewer_mail) {
		this.reviewer_mail = reviewer_mail;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public void setReview_date(String review_date) {
		this.review_date = review_date;
	}
	public void setState_review(String sr){
		state_review=sr;
	}
	public void setMark(int m){
		mark=m;
	}  
	
	
	public String toString() {
		return "Article [idArticle=" + idArticle + " "+state_review +" by "
				+ reviewer_mail + ", comment: "+comment+", mark: "+mark+"review date: "+review_date+ "]\n";
	}
	
	/**
	 * @desc Saves the objet to the database
	 * @throws SQLException
	 */
	public void saveComment_Mark() throws SQLException{
		CrudDAO<ArticleReview> c = new ArticleReviewDAO();
		c.update(this);
	}
	
//	/**
//	 * @author roske
//	 * @desc Saves the mark to the database
//	 * @throws SQLException
//	 */
//	public void saveMark() throws SQLException {
//		AgentFactory age = Agent.getDbCon();
//		age.set_ar_Mark(this.idArticle, this.reviewer_mail, this.mark);
//	}
}
