package Dominion;

import java.sql.SQLException;

import Persistence.CrudDAO;
import Persistence.MessageDAO;

public class Message {

	/**
	 * @param from, to, body, date
	 * 
	 */
	private int idMessage;
	private String email_from;
	private String email_to;
	private String body;
	private String date;

	public Message(String from, String to, String text, String date){
		this.email_from = from; 
		this.email_to = to; 
		this.body = text; 
		this.date = date; 
	}
	
	public Message(int id) throws SQLException{
		this.idMessage=id;
		CrudDAO<Message> c = new MessageDAO();
		Message m=c.read(this);
		this.idMessage=m.getId();
		this.email_from=m.getEmail_from();
		this.email_to=m.getEmail_to();
		this.body=m.getBody();
		this.date=m.getDate();
	}
	
	public Message(){
		
	}

	public int getId(){
		return idMessage;
	}
	public void setId(int id){
		this.idMessage=id;
	}
	public String getEmail_from() {
		return email_from;
	}
	public void setEmail_from(String email_from) {
		this.email_from = email_from;
	}
	public String getEmail_to() {
		return email_to;
	}
	public void setEmail_to(String email_to) {
		this.email_to = email_to;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public String toString(){
		String s=""; 
		s="\nMessage from: "+getEmail_from()+"\nTo: "+getEmail_to()+"\nDate: "+getDate()+"\n------------------------------\n"+getBody()+"\n------------------------------\n"; 
		return s;
	}
	
}
