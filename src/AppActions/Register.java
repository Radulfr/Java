package AppActions; 


import Dominion.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("unused")
public class Register extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nickname; 
	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


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


	public String getRpassword() {
		return rpassword;
	}


	public void setRpassword(String rpassword) {
		this.rpassword = rpassword;
	}


	private String email; 
	private String password;
	private String rpassword; 

	
	public String execute(){
		User u = new User(); 
		try{
			if(password.equals(rpassword)){
				u.setEmail(email);
				u.setNickname(nickname); 
				u.setPassword(password); 
				u.register(u); 
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
