package SocialNetwork.actions;

import java.util.*;

import Dominion.Message;
import Dominion.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Mensajes extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private LinkedList<Message> MessageList; 
	
	public String execute() {
		User u = new User();
		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session
		try {
			
			u = (User) session.get("user"); 
			this.MessageList = u.get_Messages(); 
			return SUCCESS; 
		}
		catch (Exception e) {
			session.put("error_message", "Error getting messages: try again please");
			return ERROR;
		}
	}

	public LinkedList<Message> getMessageList(){
		return MessageList;
	}
}
