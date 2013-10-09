package Dominion;

import java.io.Serializable;
import java.util.Calendar;


@SuppressWarnings("serial")
public class Event implements Serializable{
	private String event;
	private String date; 
	

	public Event(String event) {
		this.event = event;
		Calendar cal = Calendar.getInstance();
		this.date = cal.get(Calendar.HOUR_OF_DAY) + ":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND);
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "Event ["+date+"] - " + event;
	}

	public String getDate() {
		return " ["+date+"] ";
	}

	public void setDate(String date) {
		this.date = date;
	} 

}
