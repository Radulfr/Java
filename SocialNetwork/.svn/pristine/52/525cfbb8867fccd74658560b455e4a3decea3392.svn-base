package SocialNetwork.actions;

import java.util.Map;

import Dominion.Article;
import Dominion.User;
import Persistence.ArticleDAO;
import Persistence.CrudDAO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SetEvaluation extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id_toEvaluate; 

	
	public String execute() {
		User u = new User(); 
	
		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session	
		try {
			Article a = new Article(Integer.parseInt(id_toEvaluate)); 
			session.put("EvArticle", a.getId()); 
			System.out.println("Articulo a evaluar: " +a.getId()); 
			return SUCCESS; 
		}
		catch (Exception e) {
			session.put("error_message", "Error while reading Article");
			return ERROR;
		}
	}


	public String getId_toEvaluate() {
		return id_toEvaluate;
	}

	public void setId_toEvaluate(String id_toEvaluate) {
		this.id_toEvaluate = id_toEvaluate;
	}
}
