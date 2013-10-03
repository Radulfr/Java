package SocialNetwork.actions;

import java.util.*;
import Dominion.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Addfriend extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String newfriend; 
	
	public String execute() {
		User u = new User(); 
		User newFriend = new User(); 

		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session	
		try {
			newFriend.setEmail(newfriend);		
			u = (User) session.get("user"); 

			u.add_contact(newFriend);

			return SUCCESS; 
		}
		catch (Exception e) {
			session.put("error_message", "Add friend error: check your friend's id");
			return ERROR;
		}
	}

	public void setNewfriend(String newfriend){
		this.newfriend=newfriend;
	}
}
