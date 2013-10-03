package SocialNetwork.actions;

import java.util.*;

import Dominion.ReviewerTag;
import Dominion.User;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Searchtag extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tag;

	private LinkedList<ReviewerTag> friendlisttag; 
	private boolean foundtag=true; 
	
	public String execute() {
		User u = new User();
		LinkedList<ReviewerTag> aux=null;
		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session
		try {
			u = (User) session.get("user");
			aux=u.search_tag(this.tag); 
			if(aux!=null)
				friendlisttag=aux;
			else
				foundtag=false; 
					

			return SUCCESS; 
		}
		catch (Exception e) {
			session.put("error_message", "Error searching: check tag and try again");
			return ERROR;
		}
	}

	public boolean getFoundtag(){
		return this.foundtag;
	}
	public LinkedList<ReviewerTag> getFriendlisttag(){
		return this.friendlisttag;
	}
	public void setTag(String tag){
		this.tag = tag; 
	}

}
