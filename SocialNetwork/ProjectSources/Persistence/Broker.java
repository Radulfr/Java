package Persistence;

import java.sql.*;
import java.util.Hashtable;
import java.util.Vector;

public class Broker {
	protected static Broker instancia=null;
	protected Vector<Conexion> libres; 
	protected Hashtable <Integer, Conexion> ocupadas;
	protected final int CONEXIONES = 100; 

	protected Broker() throws SQLException {
        try {
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
        	Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		}
        this.libres=new Vector<Conexion>();
        this.ocupadas=new Hashtable<Integer, Conexion>();
        for (int i=0; i<CONEXIONES; i++) {
        	Conexion c=new Conexion(i);
        	this.libres.add(c);
        }
	}
	
	public static Broker get() throws SQLException {
		if (Broker.instancia==null) 
			instancia=new Broker();
		return instancia;
	}
	
	public Conexion getBD() throws SQLException, NoHayConexionesException {
		if (this.libres.size()==0)
			throw new NoHayConexionesException();
		synchronized (this) {
			Conexion result=this.libres.remove(0);
			this.ocupadas.put(result.getId(),result);
			return result;
		}
	}

	public void libera(Conexion bd) {
		synchronized (this) {
			this.ocupadas.remove(bd.getId());
			this.libres.add(bd);
		}
	}
}
