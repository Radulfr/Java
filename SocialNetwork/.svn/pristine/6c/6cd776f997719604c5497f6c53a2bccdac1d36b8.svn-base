package Persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.mysql.jdbc.PreparedStatement;

import Dominion.*;

public class NotificationDAO extends CrudDAO<Notification>{

    @Override
    public void create(Notification notificacion) throws SQLException {
    	
    	Broker bk; 
    	Conexion cn=null; 
    	PreparedStatement stmt; 
    	int r; 
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
			stmt = (PreparedStatement) cn.prepareStatement("INSERT INTO Notification (mail_notified, note, state, notification_date) VALUES(?,?,?,?)");
			stmt.setString(1, notificacion.getMail_notified());
			stmt.setString(2, notificacion.getNote());
			stmt.setString(3, notificacion.getState()); 
			stmt.setString(4, notificacion.getDate()); 
				
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
    public void delete(Notification notificacion) throws SQLException {
    	
    	Broker bk; 
    	Conexion cn=null; 
    	PreparedStatement stmt; 
    	int r; 
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
			stmt = (PreparedStatement) cn.prepareStatement("DELETE FROM Notificacion WHERE idNotification=?");
			stmt.setInt(1, notificacion.getId());
				
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
    public Notification read(Notification notificacion) throws SQLException { // NO se usará
    	
    	Broker bk; 
    	Conexion cn=null; 
    	PreparedStatement stmt; 
    	ResultSet rs=null;
    	
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
			stmt = (PreparedStatement) cn.prepareStatement("SELECT * FROM Notification WHERE idNotification=?");
			stmt.setInt(1, notificacion.getId());
				
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
                    notificacion.setMail_notified(rs.getString("mail_notified"));
                    notificacion.setNote(rs.getString("note"));
                    notificacion.setState(rs.getString("state"));
					notificacion.setDate(rs.getString("notification_date"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        rs.close();
        return notificacion;
    }

    @Override
    public void update(Notification notificacion) throws SQLException { 
    	
    	Broker bk; 
    	Conexion cn=null; 
    	PreparedStatement stmt; 
    	int r; 
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
			stmt = (PreparedStatement) cn.prepareStatement("UPDATE Notification SET state='READ' WHERE mail_notified=?");
			
	//		stmt.setString(1, notificacion.getState());  
			stmt.setString(1, notificacion.getMail_notified());
			
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
	public LinkedList<Notification> readAll(Notification notificacion) throws SQLException{
		
		Broker bk; 
    	Conexion cn=null; 
    	PreparedStatement stmt; 
    	ResultSet rs=null; 
		LinkedList<Notification> listArtRev = new LinkedList<Notification>();
		
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();

			if (notificacion.getState()!=null){
				stmt = (PreparedStatement) cn.prepareStatement("SELECT * FROM Notification WHERE mail_notified=? AND state = ?");
				stmt.setString(1, notificacion.getMail_notified()); 
				stmt.setString(2, notificacion.getState()); 
			}
			else{
				stmt = (PreparedStatement) cn.prepareStatement("SELECT * FROM Notification WHERE mail_notified=?");
				stmt.setString(1, notificacion.getMail_notified()); 
			}
				
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
	            	Notification n = new Notification();
	                n.setId(rs.getInt("idNotification"));
	                n.setMail_notified(rs.getString("mail_notified"));
	                n.setNote(rs.getString("note"));
                    n.setState(rs.getString("state"));
					n.setDate(rs.getString("notification_date"));
	                listArtRev.add(n);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    rs.close();
	    return listArtRev;
	}
}
