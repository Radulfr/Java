package SocialNetwork.actions;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Dominion.Article;
import Dominion.User;
import Persistence.NoHayConexionesException;

public class FriendInfo extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private String friend;
	private User userfriend; 
	private double avgMark; 
	private LinkedList<Article> articleList;
	
	public String execute() {
		User u = new User(); 
		int n=0;

		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session	
		try {	
			u = (User) session.get("user");
//			System.out.println("DATA: " +friend);
			userfriend = u.getProfile(friend);
			articleList = u.getPublications(userfriend); 
			
			 
			for(int i=0; i<articleList.size(); i++)
				n += articleList.get(i).getMark();
			
			avgMark = n / articleList.size(); 
			if(userfriend.getRol().equals("A"))
				session.put("friendrol", 1);
			else if(userfriend.getRol().equals("R"))
				session.put("friendrol", 2); 
			else
				session.put("friendrol", 3); 
			
			session.put("articleList", articleList); 
			session.put("avgMark", avgMark);

			return SUCCESS; 
		}
		catch (Exception e) {
			session.put("error_message", "Error while getting user profile. Please try again.");
			return ERROR;
		}
	}
	
	
	public String getFriend() {
		return friend;
	}
	public void setFriend(String friend) {
		this.friend = friend;
	}
	public double getAvgMark() {
		return avgMark;
	}
	public void setAvgMark(double avgMark) {
		this.avgMark = avgMark;
	}
	public LinkedList<Article> getArticleList() {
		return articleList;
	}
	public void setArticleList(LinkedList<Article> articleList) {
		this.articleList = articleList;
	}


	public User getUserfriend() {
		return userfriend;
	}


	public void setUserfriend(User userfriend) {
		this.userfriend = userfriend;
	} 

}
