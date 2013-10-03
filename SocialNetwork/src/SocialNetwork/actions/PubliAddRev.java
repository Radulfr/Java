package SocialNetwork.actions;

import java.util.*;

import Dominion.Publisher;
import Dominion.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PubliAddRev extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String addreviewer; 
	
	public String execute() {
		Publisher p; 
		User u; 
		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session
		
		try {			
			u = (User) session.get("user"); 
			p = new Publisher(u);
			p.add_reviewer(this.addreviewer);

			return SUCCESS; 
		}
		catch (Exception e) {
			session.put("error_message", "Error adding reviewer: check data and try again please");
			return ERROR;
		}
	}

	public void setAddreviewer(String addreviewer){
		this.addreviewer=addreviewer;
	}
}
