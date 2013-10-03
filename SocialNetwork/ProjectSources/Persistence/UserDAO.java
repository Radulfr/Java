package Persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.mysql.jdbc.PreparedStatement;

import Dominion.*;

public class UserDAO extends CrudDAO<User>{

    @Override
    public void create(User usuario) throws SQLException {
    	Broker bk; 
    	Conexion cn=null; 
    	PreparedStatement stmt; 
    	int r=0; 
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
     		stmt = (PreparedStatement) cn.prepareStatement("INSERT INTO User (email, name, second_name, birth_date, city, pass, rol) VALUES (?,?,?,?,?,?,?)");
    			stmt.setString(1, usuario.getEmail()); 
    			stmt.setString(2, usuario.getName()); 
    			stmt.setString(3, usuario.getSecond_name());
    			stmt.setString(4,usuario.getBirth_date());
    			stmt.setString(5, usuario.getCity());
    			stmt.setString(6, usuario.getPassword());
    			stmt.setString(7, usuario.getRol());
    				
    			r = stmt.executeUpdate();
    			
				if(usuario.getRol().equals("A")){
    				CrudDAO<Author> autordao = new AuthorDAO(); 
    				Author a = new Author(); 
    				a.setEmail(usuario.getEmail()); 
    				autordao.create(a); 
    				
    			}
    			else if(usuario.getRol().equals("R")){
    				CrudDAO<Reviewer> revdao = new ReviewerDAO(); 
    				Reviewer re = new Reviewer(); 
    				re.setEmail(usuario.getEmail());
    				revdao.create(re); 
    				
    			}
    			else if (usuario.getRol().equals("E")){
    				CrudDAO<Publisher> pdao = new PublisherDAO(); 
    				Publisher pub = new Publisher(); 
    				pub.setEmail(usuario.getEmail()); 
    				pdao.create(pub); 
    			}
 
         	}
         	catch(Exception e){
         		// TODO Captura excepci�n
         	}
         	finally{
         		cn.close();     		
         	}
    }

    @Override
    public void delete(User usuario) throws SQLException {
    	Broker bk; 
    	Conexion cn=null; 
    	PreparedStatement stmt; 
    	int r=0; 
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
     		stmt = (PreparedStatement) cn.prepareStatement("DELETE FROM User " +
    				"WHERE email=?");
    			stmt.setString(1, usuario.getEmail()); 
    				
    			r = stmt.executeUpdate();
         	}
         	catch(Exception e){
         		// TODO Captura excepci�n
         	}
         	finally{
         		cn.close();     		
         	}
    }

    @Override
    public User read(User usuario) throws SQLException {
    	Broker bk; 
    	Conexion cn=null; 
    	PreparedStatement stmt; 
    	ResultSet rs=null;
    	ReviewerTag p = new ReviewerTag();
 		bk = Broker.get(); 

     	try{


     		cn = bk.getBD();
    		if (usuario.getPassword()!=null){
    			stmt = (PreparedStatement) cn.prepareStatement("SELECT * FROM User WHERE email=? AND pass=?");
        		stmt.setString(1, usuario.getEmail());
        		stmt.setString(2, usuario.getPassword());
    		}
    		else{
         		stmt = (PreparedStatement) cn.prepareStatement("SELECT * FROM User WHERE email=?");
        		stmt.setString(1, usuario.getEmail());  
    		}
 
    			rs = stmt.executeQuery();
    			
    			if (rs != null) {
    	            try {
    	                while (rs.next()) {
    	                    usuario.setName(rs.getString("name"));
    	                    usuario.setSecond_name(rs.getString("second_name"));
    	                    usuario.setBirth_date(rs.getString("birth_date"));
    	                    usuario.setCity(rs.getString("city"));
    	                    usuario.setPassword(rs.getString("pass"));
    						usuario.setRol(rs.getString("rol"));
    	                }
    	            } catch (SQLException e) {
    	                e.printStackTrace();
    	            }
    	        }
         	}
         	catch(Exception e){
         		// TODO Captura excepci�n
         	}
         	finally{
         //		rs.close();
         		cn.close();     		
         	}
     	if(usuario.getName()==null) //TODO Comprueba que no es un dato vac�o
     		usuario=null; 
        return usuario;
    }

    @Override
    public void update(User usuario) throws SQLException {
    	Broker bk; 
    	Conexion cn=null; 
    	PreparedStatement stmt; 
    	int r=0; 
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
     		stmt = (PreparedStatement) cn.prepareStatement("UPDATE User SET name=?, second_name=?, birth_date=?, city=?, pass=?, rol=? WHERE email=?");
    			stmt.setString(1, usuario.getName()); 
    			stmt.setString(2, usuario.getSecond_name()); 
    			stmt.setString(3, usuario.getBirth_date()); 
    			stmt.setString(4, usuario.getCity());
    			stmt.setString(5, usuario.getPassword()); 
    			stmt.setString(6, usuario.getRol()); 
    			stmt.setString(7, usuario.getEmail());
    				
    			r = stmt.executeUpdate();
         	}
         	catch(Exception e){
         		// TODO Captura excepci�n
         	}
         	finally{
         		cn.close();     		
         	}       
    }

	@Override
	public LinkedList<User> readAll(User usuario) throws SQLException {
		Broker bk; 
    	Conexion cn=null; 
    	PreparedStatement stmt; 
    	ResultSet rs=null; 
    	LinkedList<User> listUser = new LinkedList<User>();
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
     		stmt = (PreparedStatement) cn.prepareStatement("SELECT * FROM User " +
    				"WHERE rol=?");
    		stmt.setString(1, usuario.getRol());
    		rs = stmt.executeQuery();
    	
    		if (rs != null) {
                try {
                    while (rs.next()) {
                    	User u = new User();
                    	u.setEmail(rs.getString("email"));
                        u.setName(rs.getString("name"));
                        u.setSecond_name(rs.getString("second_name"));
                        u.setBirth_date(rs.getString("birth_date"));
                        u.setCity(rs.getString("city"));
                        u.setPassword(rs.getString("pass"));
    					u.setRol(rs.getString("rol"));
    					listUser.add(u);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
     	}
     	catch(Exception e){
     		// TODO Captura excepci�n
     	}
     	finally{
     		rs.close();
     		cn.close();     		
     	}
        return listUser;
	}
}
