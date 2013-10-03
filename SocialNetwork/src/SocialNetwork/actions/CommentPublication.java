package SocialNetwork.actions;

import java.util.Map;

import Dominion.Article;
import Dominion.Reviewer;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CommentPublication extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idres;
	private String commenttext;
	
	public String execute() {
		Reviewer r = new Reviewer();
		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session
		try {
			r = (Reviewer) session.get("user");
			Article a = new Article(idres);
			System.out.println("Articulo " +idres); 
			r.leave_comment(a, commenttext);
			
			return SUCCESS; 
		}
		catch (Exception e) {
			session.put("error_message", "Error commenting: check your comment and try again please");
			return ERROR;
		}
	}
	
	public void setIdres(int idres){
		this.idres = idres;
	}
	
	public void setCommenttext(String commenttext){
		this.commenttext = commenttext;
	}

}
