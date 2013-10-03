package SocialNetwork.actions;

import java.util.*;

import Dominion.Publisher;
import Dominion.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PubliSearchID extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String searchid; 
	private String userfound=null;
	private boolean found=false;
	
	public String execute() {
		Publisher p; 
		User u; 
		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session
		try {			
			u = (User) session.get("user"); 
			p = new Publisher(u);
			userfound = p.search_reviewer(this.searchid).getEmail();

			if(userfound!=null)
				found=true;
			
			System.out.println(userfound);
			return SUCCESS; 
		}
		catch (Exception e) {
			session.put("error_message", "Error searching: check id and try again please");
			return ERROR;
		}
	}

	public void setSearchid(String searchid){
		this.searchid=searchid;
	}
	public String getUserfound(){
		return this.userfound;
	}
	public boolean getFound(){
		return this.found;
	}
}
