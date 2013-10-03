package SocialNetwork.actions;



import java.util.Map;

import Dominion.Article;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowArticleDetails extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idDetailsRes;
	private String idDetailsUnRes;
	private Article ar;
	
	public String UnRes() {
		
		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session
		try {

			ar = new Article(Integer.parseInt(idDetailsUnRes));
			session.put("article", ar);

			return SUCCESS; 
		}
		catch (Exception e) {
			session.put("error_message", "Error showing article details: try again please");
			return ERROR;
		}
	}
	
	public String Res() {
		
		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session
		try {

			ar = new Article(Integer.parseInt(idDetailsRes)); 
			session.put("article", ar);

			return SUCCESS; 
		}
		catch (Exception e) {
			session.put("error_message", "Error showing article details: try again please");
			return ERROR;
		}
	}
	
	public void setidDetailsRes(String idDetailsRes){
		this.idDetailsRes = idDetailsRes;
	}
	
	public void setidDetailsUnRes(String idDetailsUnRes){
		this.idDetailsUnRes = idDetailsUnRes;
	}
	
	public Article getArticle(){
		return this.ar;
	}

}
