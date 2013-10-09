package AppActions; 


import java.util.Map;

import Dominion.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String email; 
	private String password; 

	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String execute(){
		User u = new User(); 
		try{
				Map<String, Object> session = ActionContext.getContext().getSession();  // Get session
				u.setEmail(email);
				u.setPassword(password); 
				u=u.login(u); 
				if(u!=null){
					session.put("user", u);
					return SUCCESS;
				}
				else
					return ERROR; 

		}
		catch (Exception e) {
			return ERROR;
		}
	}		

}
