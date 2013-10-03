package Persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.mysql.jdbc.PreparedStatement;

import utilidades.leer;
import Dominion.Message;

public class MessageDAO extends CrudDAO<Message> {

	@Override
	public Message read(Message m) throws SQLException { // NO se usará, se devolverán todos
		
		Broker bk; 
    	Conexion cn=null; 
    	PreparedStatement stmt; 
    	ResultSet rs=null; 
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
			stmt = (PreparedStatement) cn.prepareStatement("SELECT * FROM Message WHERE idMEssage =?");
			stmt.setInt(1, m.getId());
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
						m.setBody(rs.getString("body"));
						m.setDate(rs.getString("send_date"));
						m.setEmail_from(rs.getString("mail_from"));
						m.setEmail_to(rs.getString("mail_to"));
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
            }
        }
		rs.close();
		return m;
	}

	// corresponde a send_message
	@Override
	public void create(Message m) throws SQLException {
		
		Broker bk; 
    	Conexion cn=null; 
    	PreparedStatement stmt; 
    	int r; 
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
			stmt = (PreparedStatement) cn.prepareStatement("INSERT INTO Message (mail_from, mail_to, body, send_date) VALUES(?,?,?,?)");
			stmt.setString(1, m.getEmail_from()); 
			stmt.setString(2, m.getEmail_to()); 
			stmt.setString(3, m.getBody()); 
			stmt.setString(4, m.getDate()); 
			
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
	    public void update(Message m) throws SQLException { // NO se usará
		   
			Broker bk; 
	    	Conexion cn=null; 
	    	PreparedStatement stmt; 
	    	int r; 
	     	try{
	     		bk = Broker.get(); 
	     		cn = bk.getBD();
				stmt = (PreparedStatement) cn.prepareStatement("UPDATE Message SET mail_from=?, mail_to=?, body=?, send_date=? WHERE idMessage=?");
				stmt.setString(1, m.getEmail_from()); 
				stmt.setString(2, m.getEmail_to()); 
				stmt.setString(3, m.getBody()); 
				stmt.setString(4, m.getDate()); 
				stmt.setInt(5, m.getId()); 
				
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
	public void delete(Message m) throws SQLException { // NO se usará
		
		Broker bk; 
    	Conexion cn=null; 
    	PreparedStatement stmt; 
    	int r; 
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
			stmt = (PreparedStatement) cn.prepareStatement("DELETE FROM Message WHERE idMessage=?");
			stmt.setInt(1, m.getId());
			r = stmt.executeUpdate();
     	}
     	catch(Exception e){
     		// TODO Captura excepción
     	}
     	finally{
     		cn.close();     		
     	}
	
	}

	//lee todo los mensajes mandados. Corresponde a get_user_messages
	@Override
	public LinkedList<Message> readAll(Message msg) throws SQLException {
		
		Broker bk; 
    	Conexion cn=null; 
    	PreparedStatement stmt; 
    	ResultSet rs=null; 
    	LinkedList<Message> listArtRev = new LinkedList<Message>();
    	
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
			stmt = (PreparedStatement) cn.prepareStatement("SELECT * FROM Message WHERE mail_to=?");
			stmt.setString(1, msg.getEmail_to()); 
				
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
                	Message m = new Message();
                    m.setId(rs.getInt("idMessage"));
                    m.setBody(rs.getString("body"));
        			m.setDate(rs.getString("send_date"));
        			m.setEmail_from(rs.getString("mail_from"));
        			m.setEmail_to(rs.getString("mail_to"));
                    listArtRev.add(m);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        rs.close();
        return listArtRev;
	}

}
