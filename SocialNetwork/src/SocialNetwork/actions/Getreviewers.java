package SocialNetwork.actions;

import java.util.*;

import Dominion.Publisher;
import Dominion.PublisherReviewer;
import Dominion.User;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Getreviewers extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinkedList<PublisherReviewer> revlist; 
	
	public String execute() {
		Publisher p = new Publisher(); 
		User u;
		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session
		try {

			u =  (User) session.get("user"); 

			p = new Publisher(u);

			this.revlist = p.get_Reviewer_list(); 
			if(revlist.size()>0)
				session.put("revlist", true);

			
			return SUCCESS; 
		}
		catch (Exception e) {
			session.put("error_message", "Error getting reviewers: try again please");
			return ERROR;
		}
	}

	public LinkedList<PublisherReviewer> getRevlist(){
		return this.revlist;
	}
}
