package Dominion;

import java.sql.SQLException;

import Persistence.CrudDAO;
import Persistence.NotificationDAO;

public class Notification {
	
	private int idNotification;
	private String mail_notified;
	private String note;
	private String state;
	private String date;
	
	
	
	public Notification(String mail_notified, String note, String state,
			String date) {
		this.mail_notified = mail_notified;
		this.note = note;
		this.state = state;
		this.date = date;
	}
	
	public Notification(int id) throws SQLException{
		this.idNotification=id;
		CrudDAO<Notification> c = new NotificationDAO();
		Notification n=c.read(this);
		this.mail_notified=n.getMail_notified();
		this.note= n.getNote();
		this.state= n.getState();
		this.date= n.getDate();
	}
	
	public Notification(){
		
	}

	public int getId(){
		return idNotification;
	}
	public void setId(int id){
		this.idNotification=id;
	}
	public String getMail_notified() {
		return mail_notified;
	}
	public void setMail_notified(String mail_notified) {
		this.mail_notified = mail_notified;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Notification [mail_notified=" + mail_notified + ", note="
				+ note + ", state=" + state + ", date=" + date + "]";
	}
	
	public void send() throws SQLException{
		CrudDAO<Notification> c = new NotificationDAO();
		c.create(this);
	}
	
	

}
