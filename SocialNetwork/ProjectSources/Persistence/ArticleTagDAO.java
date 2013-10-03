package Persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.mysql.jdbc.PreparedStatement;

import Dominion.*;

public class ArticleTagDAO extends CrudDAO<ArticleTag>{

    @Override
    public void create(ArticleTag at) throws SQLException {
    	
    	Broker bk; 
    	Conexion cn=null; 
    	PreparedStatement stmt; 
    	int r; 
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
			stmt = (PreparedStatement) cn.prepareStatement("INSERT INTO ArticleTag VALUES(?,?)");
			stmt.setInt(1, at.getIdArticle());
			stmt.setInt(2, at.getIdTag()); 
				
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
    public void delete(ArticleTag at) throws SQLException {
    	Broker bk; 
    	Conexion cn=null; 
    	PreparedStatement stmt; 
    	int r; 
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
			stmt = (PreparedStatement) cn.prepareStatement("DELETE FROM ArticleTag WHERE idTag=?" +
					"AND idArticle=?");
			stmt.setInt(1, at.getIdTag());
			stmt.setInt(2, at.getIdArticle());
							
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
    public ArticleTag read(ArticleTag at) throws SQLException {
    	Broker bk; 
    	Conexion cn=null; 
    	PreparedStatement stmt; 
    	ResultSet r=null; 
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
			stmt = (PreparedStatement) cn.prepareStatement("SELECT * FROM ArticleTag WHERE idArticle=?"); 
			stmt.setInt(1, at.getIdArticle());
			
							
			r = stmt.executeQuery();
     	}
     	catch(Exception e){
     		// TODO Captura excepción
     	}
     	finally{
     		cn.close();     		
     	}

        if (r != null) {
            try {
                while (r.next()) {
                    at.setIdTag(r.getInt("idTag"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        r.close();
        return at;
    }

    
    @Override
    public void update(ArticleTag at) {
    	//No se va a dar el caso. Solo se borraran y crearan nuevas
    }

    @Override
    public LinkedList<ArticleTag> readAll(ArticleTag at)throws SQLException{
    	Broker bk; 
    	Conexion cn=null; 
    	PreparedStatement stmt; 
    	ResultSet rs=null; 
       	LinkedList<ArticleTag> listArtTag = new LinkedList<ArticleTag>();
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
			stmt = (PreparedStatement) cn.prepareStatement("SELECT * FROM ArticleTag WHERE idTag=?"); 
			stmt.setInt(1, at.getIdTag());
			
			rs = stmt.executeQuery();
     	}
     	catch(Exception e){
     		// TODO Captura excepción
     	}
     	finally{
     		cn.close();     		
     	}
 
        if (rs != null) {
            try {
                while (rs.next()) {
                	ArticleTag tg = new ArticleTag();
                    tg.setIdTag(rs.getInt("idTag"));
                    tg.setIdArticle(rs.getInt("IdArticle"));
                    listArtTag.add(tg);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        rs.close();
        return listArtTag;
    }
}