package SocialNetwork.actions;

import java.util.LinkedList;
import java.util.Map;

import Dominion.Admin;
import Dominion.Author;
import Dominion.Notification;
import Dominion.Publisher;
import Dominion.Reviewer;
import Dominion.Tag;
import Dominion.User;
import Persistence.CrudDAO;
import Persistence.NotificationDAO;
import Persistence.UserDAO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String email;
	private String password;

	private User u;

	private String mostrar; 
	private LinkedList<Notification> notifications; 
	
	public String execute() {
		String R; 
		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session
		try {
			
			CrudDAO<User> c = new UserDAO(); 
			CrudDAO<Notification> d = new NotificationDAO(); 
			Notification n = new Notification(); 

			this.u = new User();
			u.setEmail(this.email); 
			u.setPassword(this.password); 
			
			notifications = u.get_notifications(); 
		//	this.u = this.u.log(this.email, this.password);
			this.u = c.read(u); 

			R = u.getRol();
			
//			n.setMail_notified(this.email); 
//			this.notifications = d.readAll(n).toString();
//			d.update(n); 
			
			this.mostrar = u.toString();

			session.put("loggedin", true);
			if(u.getRol().equals("A")){
				session.put("role", 1);
				Author a = new Author(u);
				u=a;
				Tag t = new Tag();
				session.put("tags", t.getTags());
			}
			else if(u.getRol().equals("E")){
				session.put("role", 2);
				Publisher p = new Publisher(u);
				u=p;
			}
			else if(u.getRol().equals("R")){
				session.put("role", 3);
				Reviewer r = new Reviewer(u);
				u=r;
			}
			else if(u.getRol().equals("ADMIN")){
				session.put("role", 4);
				Admin adm = new Admin(u);
				u=adm;
			}			
			session.put("user", u);

			return R;
		}
		catch (Exception e) {
			session.put("error_message", "Login failure: Check username or password");
			return ERROR;
		}
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
	public String getMostrar(){
		return mostrar;
	}
	public LinkedList<Notification> getNotifications(){
		return notifications;
	}
}
