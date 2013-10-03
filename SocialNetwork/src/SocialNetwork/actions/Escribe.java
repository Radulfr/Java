package SocialNetwork.actions;

import java.util.*;

import utilidades.leer;


import Dominion.User;
import Dominion.Message; 

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Escribe extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String messageto;
	private String messagebody;
	
	public String execute() {
		User u = new User();
		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session
		try {
			u = (User) session.get("user"); 
			String date_msg = leer.fecha(); 
			Message m = new Message(u.getEmail(), messageto, messagebody, date_msg); 
			u.write_message(m);
			return SUCCESS; 
		}
		catch (Exception e) {
			session.put("error_message", "Error sending the message: retype(sorry) the message and try again please");
			return ERROR;
		}
	}


	public void setMessageto(String messageto){
		this.messageto=messageto; 
	}
	public void setMessagebody(String messagebody){
		this.messagebody=messagebody; 
	}
}
