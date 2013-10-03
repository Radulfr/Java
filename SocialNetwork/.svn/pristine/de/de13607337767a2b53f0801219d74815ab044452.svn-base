package SocialNetwork.actions;

import java.util.*;
import Dominion.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Updateprofile extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String secondname;
	private String city;
	private String password; 
	private String password_confirmation; 
	
	public String execute() {
		User u = new User(); 
		String result=SUCCESS;
		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session	
		try {
					
			u = (User) session.get("user");
			u.setName(this.name); 
			u.setSecond_name(this.secondname);
			u.setCity(this.city);
			// TODO update password
			
			if(this.password.length()>0)
				u.setPassword(this.password);
			
			if(this.password.equals(this.password_confirmation)){
				u.edit_profile(u);
				result = SUCCESS; 
			}
			else{
				result = ERROR;
			}

			return result; 
		}
		catch (Exception e) {
			session.put("error_message", "Error updating profile: check data and try again please");
			return ERROR;
		}
	}

	public void setName(String name){
		this.name=name;
	}
	public void setSecondname(String secondname){
		this.secondname=secondname;
	}
	public void setCity(String city){
		this.city = city;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword_confirmation() {
		return password_confirmation;
	}

	public void setPassword_confirmation(String password_confirmation) {
		this.password_confirmation = password_confirmation;
	}
}
