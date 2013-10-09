package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Dominion.User;
import Interfaces.AbstractAgentFactory;


public final class AgentMySQL extends AbstractAgentFactory {

	public Connection conn;
	private Statement statement;
	public static AgentMySQL db;

	private AgentMySQL() {
		// Change data here
		// String url= "jdbc:mysql://192.168.1.248/";
		// String dbName = "ISOII";
		// String driver = "com.mysql.jdbc.Driver";
		// String userName = "root";
		// String password = "toor";

		/* configuración RRC */
		String url = "jdbc:mysql://localhost/";
		String dbName = "DungeonsDragons";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "";

		try {
			Class.forName(driver).newInstance();
			this.conn = (Connection) DriverManager.getConnection(url + dbName,
					userName, password);
		} catch (Exception sqle) {
			sqle.printStackTrace();
		}
	}

	/**
	 * 
	 * @return MysqlConnect Database connection object
	 */
	public static synchronized AgentMySQL getDbCon() {
		if (db == null) {
			db = new AgentMySQL();
		}
		return db;

	}
	

	/**
	 * 
	 * @param query
	 *            String The query to be executed
	 * @return a ResultSet object containing the results or null if not
	 *         available
	 * @throws SQLException
	 */
	public ResultSet query(String query) throws SQLException {
		statement = db.conn.createStatement();
		ResultSet res = statement.executeQuery(query);
		return res;
	}

	@Override
	public int createUser(User u) throws SQLException{
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement("INSERT INTO User (email, nickname, pass) VALUES (?,?,?)");
			stmt.setString(1, u.getEmail());
			stmt.setString(2, u.getNickname());
			stmt.setString(3, u.getPassword()); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt.executeUpdate();
	}

	@Override
	public int readUser(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(User u) {
		// TODO Auto-generated method stub
		return 0;
	}
	public ResultSet login(User u) throws SQLException{
		PreparedStatement stmt = null;
		ResultSet res;
		/*
		 * La consulta segura se hace con prepareStatement de la siguiente
		 * manera
		 */

		stmt = conn
				.prepareStatement("Select * from User where  email=? and  pass=?");
		stmt.setString(1, u.getEmail());
		stmt.setString(2, u.getPassword());
		res = stmt.executeQuery();

		return res;
	}
}
