package AppActions;


import java.util.LinkedList;
import java.util.Map;

import Dominion.Event;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Notes extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String body;
	private LinkedList<Event> notelist=null; 

	@SuppressWarnings("unchecked")
	public String execute() {
		try {
			Map<String, Object> session = ActionContext.getContext().getSession();  // Get session
			setNotelist((LinkedList<Event>)session.get("notelist"));
			
			if(getNotelist()==null){
				notelist = new LinkedList<Event>(); 
			}
			
			notelist.addFirst(new Event(getBody())); 
			session.put("notelist", notelist);
			
			return SUCCESS; 
		}
		catch (Exception e) {
			return ERROR;
		}
	}
	@SuppressWarnings("unchecked")
	public String clear() {
		try {
			Map<String, Object> session = ActionContext.getContext().getSession();  // Get session
			setNotelist((LinkedList<Event>)session.get("notelist"));
			
			if(getNotelist()!=null){
				setNotelist(null);
				session.put("notelist", notelist); 
				System.gc();
			}
			return SUCCESS; 
		}
		catch (Exception e) {
			return ERROR;
		}
	}	

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public LinkedList<Event> getNotelist() {
		return this.notelist;
	}

	public void setNotelist(LinkedList<Event> notelist) {
		this.notelist = notelist;
	}	
}
