package SocialNetwork.actions;



import java.util.Map;

import Dominion.User;
import Dominion.Author;
import Dominion.Article;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PublicationDetails extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String articleid; 
	private Article art; 
	private String comment; 
	
	public String execute() {

		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session
		try {
			
//			User u = (User)session.get("user");
//			Author a = new Author(u);
//			art = a.getArticle(articleid);
			art = new Article(Integer.parseInt(articleid));
			session.put("article", art);

			return SUCCESS; 
		}
		catch (Exception e) {
			session.put("error_message", "Error getting the article: try again please");
			return ERROR;
		}
	}
	public String comment(){
		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session
		try {
			User u = (User)session.get("user");
			Author a = new Author(u);
			art = (Article)session.get("article");
			
			a.leave_comment(art.getId(), comment); 

			return SUCCESS; 
		}
		catch (Exception e) {
			session.put("error_message", "Error leaving a commet: retype(sorry) comment and try again please");
			return ERROR;
		}

	}
	public String cancel(){
		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session
		try {//TODO Falta probar esta parte
			User u = (User)session.get("user");

			Author a = new Author(u);
			art = (Article)session.get("article");
			
			a.cancel_review(art.getId());

			return SUCCESS; 
		}
		catch (Exception e) {
			session.put("error_message", "Error cancelling: try again please");
			return ERROR;
		}

	}	
	public void setArticleid(String articleid){
		this.articleid=articleid;
	}
	public Article getArticle(){
		return this.art; 
	}
	public void setComment(String comment){
		this.comment = comment;
	}
}
