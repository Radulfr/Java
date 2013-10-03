package SocialNetwork.actions;

import java.util.Map;

import Dominion.Article;
import Dominion.Reviewer;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AssesPublication extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int articleId;
	private int idGlobal;
	
	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public int getIdGlobal() {
		return idGlobal;
	}

	public void setIdGlobal(int idGlobal) {
		this.idGlobal = idGlobal;
	}

	public String execute() {
		Reviewer r = new Reviewer();
		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session
		try {
			r = (Reviewer) session.get("user"); 
			//comprobar si ya esta evaluada
			Article ar = new Article(articleId);
			System.out.println("ACTION: " + ar.toString() +"\nNOTA: "+idGlobal); 
			if(r.asses_publication(ar, idGlobal))  return SUCCESS; 
			else return ERROR;
		}
		catch (Exception e) {
			session.put("error_message", "Error putting a mark: try again please");
			return ERROR;
		}
	}

}
