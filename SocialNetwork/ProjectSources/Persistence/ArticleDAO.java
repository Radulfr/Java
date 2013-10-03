package Persistence;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.LinkedList;

import com.mysql.jdbc.PreparedStatement;

import Dominion.*;

public class ArticleDAO extends CrudDAO<Article>{

	//Corresponde a send_publication
    @Override
    public void create(Article articulo) throws SQLException {
    	Broker bk; 
    	Conexion cn=null; 
    	PreparedStatement stmt; 
    	int r=0; 
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
			stmt = (PreparedStatement) cn.prepareStatement("INSERT INTO Article" +
				" (title, publishing_date, idAuthor," +
				" commentAuthor, state, mark, body) VALUES (?,?,?,?,?,?,?)");
			stmt.setString(1, articulo.getTitle()); 
			stmt.setString(2, articulo.getPublishing_date()); 
			stmt.setString(3, articulo.getId_author()); 
			stmt.setString(4, articulo.getComment_author());
			stmt.setString(5, articulo.getState()); 
			stmt.setInt(6, articulo.getMark()); 
			stmt.setString(7, articulo.getBody()); // TODO upload de archivos
				
			r = stmt.executeUpdate();
     	}
     	catch(Exception e){
     		// TODO Captura excepción
     	}
     	finally{
     		cn.close();     		
     	}
    }

    @Override
    public void delete(Article articulo) throws SQLException {
    	
    	Broker bk; 
    	Conexion cn=null; 
    	PreparedStatement stmt; 
    	int r; 
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
			stmt = (PreparedStatement) cn.prepareStatement("DELETE FROM Article WHERE idArticle=?");
			stmt.setInt(1, articulo.getId()); 
				
			r = stmt.executeUpdate();
     	}
     	catch(Exception e){
     		// TODO Captura excepción
     	}
     	finally{
     		cn.close();     		
     	}
    }
    
    
    //Corresponde a get_article_by_id del antiguo agente
    @Override
    public Article read(Article articulo) throws SQLException {
    	
    	Broker bk; 
    	Conexion cn=null; 
    	PreparedStatement stmt; 
    	ResultSet r=null; 
 		bk = Broker.get(); 
 		try {
			cn = bk.getBD();
		} catch (NoHayConexionesException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	if (articulo.getId()==0){ //buscar el id
    		stmt = (PreparedStatement) cn.prepareStatement("SELECT * FROM Article WHERE title=? AND publishing_date=? AND idAuthor=?");
    		stmt.setString(1, articulo.getTitle()); 
    		stmt.setString(2, articulo.getPublishing_date()); 
    		stmt.setString(3, articulo.getId_author());

        	r = stmt.executeQuery(); 
    	}
    	else{
         	try{

    			stmt = (PreparedStatement) cn.prepareStatement("SELECT * FROM Article WHERE idArticle=?"); 
    			stmt.setInt(1, articulo.getId()); 
    				
    			r = stmt.executeQuery();
         	}
         	catch(Exception e){
         		// TODO Captura excepción
         	}
    	}
    	
        if (r != null) {
            try {
                while (r.next()) {
                    articulo.setId(r.getInt("idArticle"));
                    articulo.setTitle(r.getString("title"));
                    articulo.setPublishing_date(r.getString("publishing_date"));
                    articulo.setId_author(r.getString("idAuthor"));
					articulo.setComment_author(r.getString("commentAuthor"));
					articulo.setState(r.getString("state"));
					articulo.setMark(r.getInt("mark"));
					articulo.setBody(r.getString("body"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally{
            	cn.close();
            }
        }
        return articulo;
    }

    //Actualiza el objeto entero. Si quiero CancelReview o setCommentInArticle pues de debe modificar el objeto para actualizar
    @Override
    public void update(Article articulo) throws SQLException {
    	
    	Broker bk; 
    	Conexion cn=null; 
    	PreparedStatement stmt; 
    	int r=0; 
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
			stmt = (PreparedStatement) cn.prepareStatement("UPDATE Article SET title=?," +
					"publishing_date=?, idAuthor=?, commentAuthor=?, state=?, mark=?" +
					" WHERE idArticle=?"); 
			stmt.setString(1, articulo.getTitle());
			stmt.setString(2, articulo.getPublishing_date()); 
			stmt.setString(3, articulo.getId_author()); 
			stmt.setString(4, articulo.getComment_author()); 
			stmt.setString(5, articulo.getState()); 
			stmt.setInt(6, articulo.getMark()); 
			stmt.setInt(7, articulo.getId()); 
				
			r = stmt.executeUpdate();
     	}
     	catch(Exception e){
     		// TODO Captura excepción
     	}
     	finally{
     		cn.close(); 
     	}
    }
    
    //Lee todos los articulos por su estado si se rellena o todos en general.
    //Corresponde con get_articles_with_state | get_publicationsAuthor del antiguo agente
    @SuppressWarnings("null")
	@Override
    public LinkedList<Article> readAll(Article articulo) throws SQLException{
    	Broker bk; 
    	Conexion cn=null; 
    	PreparedStatement stmt=null; 
    	ResultSet r=null; 

    	bk = Broker.get(); 
 		try {
			cn = bk.getBD();
			if(articulo.getId_author()!= null){
				stmt=(PreparedStatement) cn.prepareStatement("SELECT * FROM Article WHERE idAuthor=?");
				stmt.setString(1, articulo.getId_author());
			}
			else if(articulo.getState()!=null){
				stmt=(PreparedStatement) cn.prepareStatement("SELECT * FROM Article WHERE state = ?");
				stmt.setString(1, articulo.getState());
			}
			else{
				stmt=(PreparedStatement) cn.prepareStatement("SELECT * FROM Article");
			}
		} catch (NoHayConexionesException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
/*
 * He modificado esto. Basta con rescatar todos los artículos de un determinado autor
 * después se filtran directamente en la lista.     	
 */
    	
/*    	if (articulo.getState()==null){
    		if (articulo.getId_author()==null){
    			stmt = (PreparedStatement) cn.prepareStatement("SELECT * FROM Article"); 
    		}else{ 
    			if (articulo.getTitle()!=null){ //si busco por autor y titulo
    				stmt = (PreparedStatement) cn.prepareStatement("SELECT * FROM Article WHERE title=? " +
    						"AND idAuthor=?");
    				stmt.setString(1, articulo.getTitle()); 
    				stmt.setString(2, articulo.getId_author()); 
    			}
    			else{
    				stmt = (PreparedStatement) cn.prepareStatement("SELECT * FROM Article WHERE idAuthor=?"); 
    				stmt.setString(1, articulo.getId_author()); 
    			}
    		}
    	}
    	else { //si solo busco por estado
    		stmt = (PreparedStatement) cn.prepareStatement("SELECT * FROM Article WHERE state=?");
    		stmt.setString(1, articulo.getState());
    	}*/
    	r = stmt.executeQuery();
    	
    	LinkedList<Article> listArt = new LinkedList<Article>();
        if (r != null) {
            try {
                while (r.next()) {
                	Article a = new Article();
                    a.setId(r.getInt("idArticle"));
                    a.setTitle(r.getString("title"));
                    a.setPublishing_date(r.getString("publishing_date"));
                    a.setId_author(r.getString("idAuthor"));
					a.setComment_author(r.getString("commentAuthor"));
					a.setState(r.getString("state"));
					a.setMark(r.getInt("mark"));
					a.setBody(r.getString("body"));
					listArt.add(a);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally{
            	cn.close();
            }
        }
        r.close();
        return listArt;
    }
}
