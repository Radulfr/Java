package SocialNetwork.actions;

import java.util.LinkedList;
import java.util.Map;

import Dominion.Follows;
import Dominion.User;
import Persistence.CrudDAO;
import Persistence.FollowsDAO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Amigos extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinkedList<Follows> friendlist; 
	
	public String execute() {
		User u = new User(); 
		CrudDAO<Follows> c = new FollowsDAO(); 
		Follows a = new Follows();
		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session
		try {

			u = (User) session.get("user"); 
			a.setFollower_mail(u.getEmail());
			
			this.friendlist = c.readAll(a); 
//			System.out.println(u.getEmail() +" ---> "+ friendlist.toString()); 
			return SUCCESS; 
		}
		catch (Exception e) {
			session.put("error_message", "Error getting friends: try again please");
			return ERROR;
		}
	}

	public LinkedList<Follows> getFriendlist(){
		return friendlist;
	}
}
