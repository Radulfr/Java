package Persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.mysql.jdbc.PreparedStatement;

import Dominion.*;

public class PublisherDAO extends CrudDAO<Publisher>{

    @Override
    public void create(Publisher publi) throws SQLException {
    	
    	Broker bk; 
    	Conexion cn = null; 
    	PreparedStatement stmt;
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
     		
     		stmt = (PreparedStatement) cn.prepareStatement("INSERT INTO User (email, name, second_name, birth_date, city, pass, rol) VALUES (?, ?, ?, ?, ?, ?, ?)");
     		stmt.setString(1, publi.getEmail());
     		stmt.setString(2, publi.getName());
     		stmt.setString(3, publi.getSecond_name());
     		stmt.setString(4, publi.getBirth_date());
     		stmt.setString(5, publi.getCity());
     		stmt.setString(6, publi.getPassword());
     		stmt.setString(7, "E");
     		stmt.executeUpdate();
     		
     		stmt = (PreparedStatement) cn.prepareStatement("INSERT INTO Publisher (email, journal, web) VALUES (?, ?, ?)");
     		stmt.setString(1, publi.getEmail());
     		stmt.setString(2, publi.getJournal());
     		stmt.setString(3, publi.getWeb());
     		stmt.executeUpdate();
     		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			cn.close();
		}
    }

    @Override
    public void delete(Publisher publi) throws SQLException {
    	Broker bk; 
    	Conexion cn = null; 
    	PreparedStatement stmt;
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
     		
     		stmt = (PreparedStatement) cn.prepareStatement("DELETE FROM User WHERE email=?");
     		stmt.setString(1, publi.getEmail());
     		stmt.executeUpdate();
     		
     		stmt = (PreparedStatement) cn.prepareStatement("DELETE FROM Publisher WHERE email=?");
     		stmt.setString(1, publi.getEmail());
     		stmt.executeUpdate();
     		
 		} catch (Exception e) {
 			e.printStackTrace();
 		}finally{
 			cn.close();
 		}
    }

    @Override
    public Publisher read(Publisher publi) throws SQLException {
    	
    	Broker bk; 
    	Conexion cn = null; 
    	PreparedStatement stmt;
    	ResultSet rs = null;
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
     		
     		stmt = (PreparedStatement) cn.prepareStatement("SELECT * FROM Publisher WHERE email=?");
     		stmt.setString(1, publi.getEmail());
     		rs = stmt.executeQuery();
     	}catch(Exception e){
     		e.printStackTrace();
     	}finally{
     		cn.close();
     	}
     		
        if (rs != null) {
            try {
                while (rs.next()) {
                    publi.setJournal(rs.getString("journal"));
                    publi.setWeb(rs.getString("web"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        rs.close();
        
        ResultSet rs2 = null;
        try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
     		
     		stmt = (PreparedStatement) cn.prepareStatement("SELECT * FROM User WHERE email=?");
     		stmt.setString(1, publi.getEmail());
     		rs2 = stmt.executeQuery();
        }catch(Exception e){
        	e.printStackTrace();
        }finally{
        	cn.close();
        }
        
        if (rs2 != null) {
            try {
                while (rs2.next()) {
                    publi.setName(rs2.getString("name"));
                    publi.setSecond_name(rs2.getString("second_name"));
                    publi.setBirth_date(rs2.getString("birth_date"));
                    publi.setCity(rs2.getString("city"));
                    publi.setPassword(rs2.getString("pass"));
					publi.setRol(rs2.getString("rol"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        rs2.close();
        return publi;
    }

    @Override
    public void update(Publisher publi) throws SQLException {
    	
    	Broker bk; 
    	Conexion cn = null; 
    	PreparedStatement stmt;
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
     		
     		stmt = (PreparedStatement) cn.prepareStatement("UPDATE Publisher SET " +
     				"journal=?, web=? WHERE email=?");
     		stmt.setString(1, publi.getJournal());
     		stmt.setString(2, publi.getWeb());
     		stmt.setString(3, publi.getEmail());
     		stmt.executeUpdate();
     		
     		stmt = (PreparedStatement) cn.prepareStatement("UPDATE User SET name=?, second_name=?, " +
     				"birth_date=?, city=?, pass=?, rol=? WHERE email=?");
     		stmt.setString(1, publi.getName());
     		stmt.setString(2, publi.getSecond_name());
     		stmt.setString(3, publi.getBirth_date());
     		stmt.setString(4, publi.getCity());
     		stmt.setString(5, publi.getPassword());
     		stmt.setString(6, publi.getRol());
     		stmt.setString(7, publi.getEmail());
     		stmt.executeUpdate();
     		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			cn.close();
		}
    }

	@Override
	public LinkedList<Publisher> readAll(Publisher obj) throws SQLException {
		
		Broker bk; 
    	Conexion cn = null; 
    	PreparedStatement stmt;
    	ResultSet rs = null;
     	try{
     		bk = Broker.get(); 
     		cn = bk.getBD();
     		
     		stmt = (PreparedStatement) cn.prepareStatement("SELECT * FROM Publisher");
     		rs = stmt.executeQuery();
     	}catch(Exception e){
     		e.printStackTrace();
     	}finally{
     		cn.close();
     	}
     	
    	LinkedList<Publisher> listPublisher = new LinkedList<Publisher>();
    	
    	ResultSet rs2 = null;
        if (rs != null) {
            try {
                while (rs.next()) {
                	Publisher p = new Publisher();
                	p.setEmail(rs.getString("email"));
                    p.setJournal(rs.getString("journal"));
                    p.setWeb(rs.getString("web"));
                    try{
	                    bk = Broker.get(); 
	             		cn = bk.getBD();
	             		stmt = (PreparedStatement) cn.prepareStatement("SELECT * FROM User WHERE email=?");
	             		stmt.setString(1, p.getEmail());
	             		rs2 = stmt.executeQuery();
                    }catch(Exception e){
                    	e.printStackTrace();
                    }finally{
                    	cn.close();
                    }
                    
                    if (rs2 != null) {
                        try {
                            while (rs2.next()) {
                                p.setName(rs2.getString("name"));
                                p.setSecond_name(rs2.getString("second_name"));
                                p.setBirth_date(rs2.getString("birth_date"));
                                p.setCity(rs2.getString("city"));
                                p.setPassword(rs2.getString("pass"));
            					p.setRol(rs2.getString("rol"));
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    rs2.close();
                    listPublisher.add(p);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        rs.close();
        return listPublisher;
	}
}
