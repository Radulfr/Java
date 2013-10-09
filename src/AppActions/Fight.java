package AppActions;


import Dominion.Event;


import java.util.LinkedList;
import java.util.Map;

import Dominion.Combat_Player;
import Dominion.DDSystem;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class Fight extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String player; 
	private String init; 
	private LinkedList<Combat_Player> combatlist;
	private LinkedList<Event> eventlist=null;
	private String delplayer; 
	private int hit; 
	private String hitplayer; 
	private String idamage; 
	private String move_player; 
	private String movement; 
	static final int UP = 1;
	static final int DOWN = 2; 
	

	public String getHitplayer() {
		return hitplayer;
	}
	public void setHitplayer(String hitplayer) {
		this.hitplayer = hitplayer;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getDelplayer() {
		return delplayer;
	}
	public void setDelplayer(String delplayer) {
		this.delplayer = delplayer;
	}
	public String execute() {
		
		try {
//			Map<String, Object> session = ActionContext.getContext().getSession();  // Get session
			
			
			return SUCCESS; 
		}
		catch (Exception e) {
			return ERROR;
		}
	}
	@SuppressWarnings("unchecked")
	public String add(){
		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session
		try{
			Combat_Player c = new Combat_Player(player, "noclass", 0, 0); 
			c.setInitiative(Integer.parseInt(init)); 
			c.setHitpoints(Integer.parseInt(getIdamage())); 
			this.combatlist =  (LinkedList<Combat_Player>) session.get("combatlist");
			if(combatlist == null)
				combatlist = new LinkedList<Combat_Player>();
				
			combatlist.add(c);
			session.put("combatlist", combatlist);
			
			
			eventlist = (LinkedList<Event>) session.get("eventlist");
			if(eventlist == null){
				eventlist = new LinkedList<Event>(); 
				session.put("eventlist", eventlist);
			}
			Event ev = new Event(c.getName()+" has arrived");
			eventlist.addFirst(ev); 
			
			return SUCCESS;
		}
		catch (Exception e) {
			return ERROR;
		}
	}

	@SuppressWarnings("unchecked")
	public String sort(){
		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session
		DDSystem s = new DDSystem(); 
		try{
			
			this.combatlist =  (LinkedList<Combat_Player>) session.get("combatlist");
			this.combatlist = s.combatsort(combatlist); 
			this.eventlist =  (LinkedList<Event>) session.get("eventlist");
			return SUCCESS;
		}
		catch (Exception e) {
			return ERROR;
		}
	}
	@SuppressWarnings("unchecked")
	public String delete(){
		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session
		DDSystem s = new DDSystem(); 
		Combat_Player c = new Combat_Player(delplayer, "noclass", 0, 0); 
		try{
			
			this.combatlist =  (LinkedList<Combat_Player>) session.get("combatlist");
			this.combatlist = s.combatdelete(combatlist, c); 
			
			session.put("combatlist", combatlist);
			eventlist = (LinkedList<Event>) session.get("eventlist"); 
			Event ev = new Event(c.getName()+" out of combat");
			eventlist.addFirst(ev); 
			return SUCCESS;
		}
		catch (Exception e) {
			return ERROR;
		}
	}	
	@SuppressWarnings("unchecked")
	public String hit(){
		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session
		DDSystem s = new DDSystem(); 
		Combat_Player c; 
		try{

			this.combatlist =  (LinkedList<Combat_Player>) session.get("combatlist");
			c = s.searchPlayer(combatlist, hitplayer); 
			c.setHitpoints(c.getHitpoints()+hit); 
			eventlist = (LinkedList<Event>) session.get("eventlist"); 
			Event ev = new Event(c.getName()+" has recieved damage ("+hit+")");
			eventlist.addFirst(ev); 
			return SUCCESS;
		}
		catch (Exception e) {
			return ERROR;
		}
	}	
	public String end(){
		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session
		try{
			session.remove("combatlist"); 
			session.remove("eventlist");
			System.gc();
			return SUCCESS;
		}
		catch (Exception e) {
			return ERROR;
		}
	}		
	@SuppressWarnings("unchecked")
	public String up_player(){
		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session
		DDSystem s = new DDSystem(); 
		Combat_Player c; 
		int position; 
		try{

			this.combatlist =  (LinkedList<Combat_Player>) session.get("combatlist");
			c = s.searchPlayer(combatlist, move_player);
			position = s.getIndexOfPlayer(c, combatlist); 
			this.combatlist = s.move_player(c, position, combatlist, UP); 
			session.put("combatlist", combatlist);
			eventlist = (LinkedList<Event>) session.get("eventlist"); 
			Event ev = new Event(c.getName()+" has delayed action");
			eventlist.addFirst(ev); 
			session.put("eventlist", eventlist);
			return SUCCESS;
		}
		catch (Exception e) {
			return ERROR;
		}
	}		
	@SuppressWarnings("unchecked")
	public String down_player(){
		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session
		DDSystem s = new DDSystem(); 
		Combat_Player c; 
		int position; 
		try{

			this.combatlist =  (LinkedList<Combat_Player>) session.get("combatlist");
			c = s.searchPlayer(combatlist, move_player);
			position = s.getIndexOfPlayer(c, combatlist); 
			this.combatlist = s.move_player(c, position, combatlist, DOWN); 
			session.put("combatlist", combatlist);
			eventlist = (LinkedList<Event>) session.get("eventlist"); 
			Event ev = new Event(c.getName()+" has delayed action");
			eventlist.addFirst(ev); 
			session.put("eventlist", eventlist);
			return SUCCESS;
		}
		catch (Exception e) {
			return ERROR;
		}
	}	/*
	@SuppressWarnings("unchecked")
	public String move_player(){
		Map<String, Object> session = ActionContext.getContext().getSession();  // Get session
		DDSystem s = new DDSystem(); 
		Combat_Player c; 
		int position; 
		try{
			this.combatlist =  (LinkedList<Combat_Player>) session.get("combatlist");
			c = s.searchPlayer(combatlist, move_player);
			position = s.getIndexOfPlayer(c, combatlist); 
			System.out.println(">>> "+ getMovement());
			
			if(getMovement().equals("UP"))
				this.combatlist = s.move_player(c, position, combatlist, UP);
			else
				this.combatlist = s.move_player(c, position, combatlist, DOWN);
			
			session.put("combatlist", combatlist);
			eventlist = (LinkedList<Event>) session.get("eventlist"); 
			Event ev = new Event(c.getName()+" has delayed action");
			eventlist.addFirst(ev); 
			session.put("eventlist", eventlist);
			return SUCCESS;
		}
		catch (Exception e) {
			return ERROR;
		}
	}	*/
	public LinkedList<Combat_Player> getCombatlist() {
		return combatlist;
	}
	public void setCombatlist(LinkedList<Combat_Player> combatlist) {
		this.combatlist = combatlist;
	}
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
	public String getInit() {
		return init;
	}
	public void setInit(String init) {
		this.init = init;
	}
	public LinkedList<Event> getEventlist() {
		return eventlist;
	}
	public void setEventlist(LinkedList<Event> eventlist) {
		this.eventlist = eventlist;
	}
	public String getIdamage() {
		return idamage;
	}
	public void setIdamage(String idamage) {
		this.idamage = idamage;
	}
	public String getMove_player() {
		return move_player;
	}
	public void setMove_player(String move_player) {
		this.move_player = move_player;
	}
	public String getMovement() {
		return movement;
	}
	public void setMovement(String movement) {
		this.movement = movement;
	}	
}
