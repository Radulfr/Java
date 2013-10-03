package SocialNetwork.actions;

import java.util.LinkedList;
import java.util.Map;

import Dominion.ArticleReview;
import Dominion.Reviewer;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowUnresolvedPublications extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinkedList<ArticleReview> articleReviewList;
	
	public String execute() {
		Reviewer r = new Reviewer();
		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session
		try {
			
			r = (Reviewer) session.get("user");
			this.articleReviewList = r.get_unresolved_reviews();
			return SUCCESS; 
		}
		catch (Exception e) {
			session.put("error_message", "Error getting unresolved publications: please try again");
			return ERROR;
		}
	}


	public LinkedList<ArticleReview> getArticleReviewList(){
		return this.articleReviewList;
	}
	
	public boolean getFoundUnres(){
		return !this.articleReviewList.isEmpty();
	}

}
