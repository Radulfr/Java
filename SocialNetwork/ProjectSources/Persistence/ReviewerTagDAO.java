package Persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.mysql.jdbc.PreparedStatement;

import Dominion.*;

public class ReviewerTagDAO extends CrudDAO<ReviewerTag>{

    @Override
    public void create(ReviewerTag rt) throws SQLException {
    	Broker bk; 
    	Conexion cn=null; 
    	PreparedStatement stmt; 
    	int r=0; 
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
     		stmt = (PreparedStatement) cn.prepareStatement("INSERT INTO ReviewerTag " +
    				"VALUES (?,?)");
    			stmt.setString(1, rt.getReviewer_mail()); 
    			stmt.setInt(2, rt.getIdTag()); 
    				
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
    public void delete(ReviewerTag rt) throws SQLException {
    	Broker bk; 
    	Conexion cn=null; 
    	PreparedStatement stmt; 
    	int r=0; 
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
     		stmt = (PreparedStatement) cn.prepareStatement("DELETE FROM ReviewerTag " +
    				"WHERE reviewer_mail=? AND idTag=?");
    			stmt.setString(1, rt.getReviewer_mail()); 
    			stmt.setInt(2, rt.getIdTag()); 
    				
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
    public ReviewerTag read(ReviewerTag rt) throws SQLException {
    	Broker bk; 
    	Conexion cn=null; 
    	PreparedStatement stmt; 
    	ResultSet rs=null;
    	ReviewerTag p = new ReviewerTag();
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
     		stmt = (PreparedStatement) cn.prepareStatement("SELECT * FROM ReviewerTag " +
    				"WHERE reviewer_mail=? AND idTag=?");
    			stmt.setString(1, rt.getReviewer_mail()); 
    			stmt.setInt(2, rt.getIdTag()); 
 
    			rs = stmt.executeQuery();
    			
    			if (rs != null) {
    	            try {
    	                while (rs.next()) {
    	                    p.setIdTag(rs.getInt("idTag"));
    	                    p.setReviewer_mail(rs.getString("reviewer_mail"));
    	                }
    	            } catch (SQLException e) {
    	                e.printStackTrace();
    	            }
    	        }
         	}
         	catch(Exception e){
         		// TODO Captura excepción
         	}
         	finally{
         		rs.close();
         		cn.close();     		
         	}
        return p;
    }

    @Override
    public void update(ReviewerTag rt) {
    	 //No se va a dar el caso. Solo se crean o se borran       
    }
    
    @Override
    public LinkedList<ReviewerTag> readAll(ReviewerTag rt)throws SQLException{
    	Broker bk; 
    	Conexion cn=null; 
    	PreparedStatement stmt; 
    	ResultSet rs=null; 
    	LinkedList<ReviewerTag> listRevTag = new LinkedList<ReviewerTag>();
     	try{

     		bk = Broker.get(); 
     		cn = bk.getBD();
     		
     		if (rt.getReviewer_mail()==null){
        		if (rt.getIdTag()==0){
        			stmt = (PreparedStatement) cn.prepareStatement("SELECT * FROM ReviewerTag");
        		}
        		else{
        			stmt = (PreparedStatement) cn.prepareStatement("SELECT * FROM ReviewerTag " +
            				"WHERE idTag=?");
            		stmt.setInt(1, rt.getIdTag());
        		}
        	}else{
        		stmt = (PreparedStatement) cn.prepareStatement("SELECT * FROM ReviewerTag " +
        				"WHERE reviewer_mail=?");
        		stmt.setString(1, rt.getReviewer_mail());
        	}
    		rs = stmt.executeQuery();
    		
    		if (rs != null) {
                try {
                    while (rs.next()) {
                    	ReviewerTag rev = new ReviewerTag();
                        rev.setIdTag(rs.getInt("idTag"));
                        rev.setReviewer_mail(rs.getString("reviewer_mail"));
                        listRevTag.add(rev);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
     	}
     	catch(Exception e){
     		// TODO Captura excepción
     	}
     	finally{
     		rs.close();
     		cn.close();     		
     	}
        return listRevTag;
    }
}