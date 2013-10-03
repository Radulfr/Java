package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AgenteBD {
	public Connection conn;
    public static AgenteBD db;
    private Statement statement;
	    

	// method to create Cloudscape connections
	private AgenteBD() {
	 // Use DRIVER and DBURL to create a connection
	 // Recommend connection pool implementation/usage
		
		String url= "jdbc:mysql://localhost/";
        String dbName = "ISOII";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "toor";
        
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection)DriverManager.getConnection(url+dbName,userName,password);
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
        
	}
	
    public static synchronized AgenteBD getDbCon() {
        if ( db == null ) {
            db = new AgenteBD();
        }
        return db;

    }
    
    public ResultSet query(String query) throws SQLException{
        statement = db.conn.createStatement();
        ResultSet res = statement.executeQuery(query);
        return res;
    }
    
    public int queryUpdate(String query) throws SQLException{
        statement = db.conn.createStatement();
        int res = statement.executeUpdate(query);
        return res;
    }
}