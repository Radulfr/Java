package SocialNetwork.actions;

import java.util.Map;

import Dominion.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Buscar extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String userfound="nothing"; 
	private String userid=" "; 
	private boolean found=true; 
	
	public String execute() {
		User u = new User();
		User aux=null;
		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session
		try {
			u = (User) session.get("user");
			aux = u.search_userById(this.name);
			
			if(aux!=null){
				userfound="["+aux.getEmail() + "] " + aux.getName() + " " + aux.getSecond_name() + " [" + aux.getRol()+"]" ;
				userid = aux.getEmail();
				
			}
			else
				found=false; 
					
			session.put("userfound", userfound);
			session.put("userid", userid);

			return SUCCESS; 
		}
		catch (Exception e) {
			session.put("error_message", "Error searching: check data and try again please");
			return ERROR;
		}
	}


	public void setName(String name){
		this.name=name; 
	}
	public String getUserfound(){
		return this.userfound; 
	}
	public String getUserid(){
		return this.userid; 
	}
	public boolean getFound(){
		return this.found;
	}

}
