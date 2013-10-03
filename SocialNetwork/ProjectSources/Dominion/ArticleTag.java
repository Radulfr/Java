package Dominion;

import java.sql.SQLException;

import Persistence.ArticleTagDAO;
import Persistence.CrudDAO;


public class ArticleTag {
	
	private int idTag;
	private int idArticle;
	
	
	public ArticleTag(int idArticle, int idTag){
		this.idArticle=idArticle;
		this.idTag=idTag;
	}
	
	public ArticleTag(int idArticle) throws SQLException{
		this.idArticle=idArticle;
		CrudDAO<ArticleTag> c= new ArticleTagDAO();
		ArticleTag at = c.read(this);
		this.idTag= at.getIdTag();
	}
	
	public ArticleTag(){
		
	}
	
	public int getIdTag() {
		return idTag;
	}

	public void setIdTag(int idTag) {
		this.idTag = idTag;
	}

	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int id) {
		this.idArticle = id;
	}
	
	@Override
	public String toString() {
		return "ArticleTag [idArticle=" + idArticle + ", idTag=" + idTag + "]\n";
	}
	
}