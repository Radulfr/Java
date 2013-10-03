package SocialNetwork.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Map;

import Dominion.Article;
import Persistence.ArticleDAO;
import Persistence.CrudDAO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idArticle;
	private InputStream fileInputStream;

	public void setIdArticle(int id) {
		this.idArticle = id;
	}
	
	public InputStream getFileInputStream() {
		return fileInputStream;
	}

	public String execute() throws SQLException {
		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session
		try{
			Article a = new Article(this.idArticle);
			CrudDAO<Article> dao_a = new ArticleDAO();
			a = dao_a.read(a);
			String path = "pdfs/" + a.getId_author() + "/" + a.getBody();
			fileInputStream = new FileInputStream(new File(path));
		} catch (IOException e){
			session.put("error_message", "Error downloading: try again please");
			return ERROR;
		}
		
		return SUCCESS;
	}
}