package SocialNetwork.actions;

import java.util.*;

import Dominion.ArticleReview;
import Dominion.Publisher;
import Dominion.User;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Getrevision extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinkedList<ArticleReview> revs; 
	private String rev; 
	private boolean results=false;
	
	public String execute() {
		Publisher p = new Publisher(); 
		User u;
		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session
		try {

			u =  (User) session.get("user"); 
			p = new Publisher(u.getEmail());
			
			revs = p.get_review(rev);
			if(revs.size()>0)
				results=true;
			
			return SUCCESS; 
		}
		catch (Exception e) {
			session.put("error_message", "Error getting a revision: try again please");
			return ERROR;
		}
	}

	public LinkedList<ArticleReview> getRevs(){
		return this.revs;
	}
	public void setRev(String rev){
		this.rev = rev; 
	}
	public boolean getResults(){
		return this.results;
	}
}
