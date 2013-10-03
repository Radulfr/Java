package SocialNetwork.actions;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Logout extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	public String execute() {
		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session 
		try {
			session.clear(); 
		
		}
		catch (Exception e) {
			session.put("error_message", "Error logging out: you did NOT logged out!! try again please");
			return ERROR;
		}
		return SUCCESS;
	}
}
