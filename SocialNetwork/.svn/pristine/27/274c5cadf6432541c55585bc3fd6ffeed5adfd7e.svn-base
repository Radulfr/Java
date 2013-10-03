package Persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.mysql.jdbc.PreparedStatement;

import Dominion.*;

public class PublisherReviewerDAO extends CrudDAO<PublisherReviewer>{

    @Override
    public void create(PublisherReviewer pr) throws SQLException {
    	Broker bk; 
    	Conexion cn=null; 
    	PreparedStatement stmt; 
    	int r=0; 
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
     		stmt = (PreparedStatement) cn.prepareStatement("INSERT INTO PublisherReviewer " +
    				"VALUES (?,?)");
    			stmt.setString(1, pr.getPublisher_mail()); 
    			stmt.setString(2, pr.getReviewer_mail()); 
    				
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
    public void delete(PublisherReviewer pr) throws SQLException {
    	Broker bk; 
    	Conexion cn=null; 
    	PreparedStatement stmt; 
    	int r=0; 
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
     		stmt = (PreparedStatement) cn.prepareStatement("DELETE FROM PublisherReviewer " +
    				"WHERE publisher_mail=? AND reviewer_mail=?");
    			stmt.setString(1, pr.getPublisher_mail()); 
    			stmt.setString(2, pr.getReviewer_mail()); 
    				
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
    public PublisherReviewer read(PublisherReviewer pr) throws SQLException {
    	Broker bk; 
    	Conexion cn=null; 
    	PreparedStatement stmt; 
    	ResultSet rs=null;
    	PublisherReviewer p = new PublisherReviewer();
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
     		stmt = (PreparedStatement) cn.prepareStatement("SELECT * FROM PublisherReviewer " +
    				"WHERE publisher_mail=? AND reviewer_mail=?");
    			stmt.setString(1, pr.getPublisher_mail()); 
    			stmt.setString(2, pr.getReviewer_mail()); 
 
    			rs = stmt.executeQuery();
    			
    	        if (rs != null) {
    	            try {
    	            	 while (rs.next()) {
    	                     p.setPublisher_mail(rs.getString("publisher_mail"));
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
    public void update(PublisherReviewer t) {
    	//No se va a dar el caso. Solo se borran y crean      
    }
    
    
    @Override
    public LinkedList<PublisherReviewer> readAll(PublisherReviewer pr)throws SQLException{
    	Broker bk; 
    	Conexion cn=null; 
    	PreparedStatement stmt; 
    	ResultSet rs=null; 
    	LinkedList<PublisherReviewer> listPublisherReviewer = new LinkedList<PublisherReviewer>();
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
     		stmt = (PreparedStatement) cn.prepareStatement("SELECT * FROM PublisherReviewer " +
    				"WHERE publisher_mail=?");
    		stmt.setString(1, pr.getPublisher_mail());
    		rs = stmt.executeQuery();
    	
	        if (rs != null) {
	            try {
	                while (rs.next()) {
	                	PublisherReviewer p = new PublisherReviewer();
	                    p.setPublisher_mail(rs.getString("publisher_mail"));
	                    p.setReviewer_mail(rs.getString("reviewer_mail"));
	                    listPublisherReviewer.add(p);
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
        return listPublisherReviewer;
    }
}