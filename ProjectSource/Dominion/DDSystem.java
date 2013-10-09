package Dominion;

import java.util.Collections;
import java.util.LinkedList;

public class DDSystem {

	private LinkedList<Player> playerlist;
	
	public LinkedList<Combat_Player> combatlist; 

	static final int UP = 1;
	static final int DOWN = 2; 
	
	public LinkedList<Player> getPlayerlist() {
		return playerlist;
	}

	public void setPlayerlist(LinkedList<Player> playerlist) {
		this.playerlist = playerlist;
	} 
	/*
	 * Ordena la lista y la invierte
	 * usa el Collections de Java
	 * Necesita implementar compareTo
	 * interfaz Comparable
	 */
	public LinkedList<Combat_Player> combatsort(LinkedList<Combat_Player> combatlist){
		Collections.sort(combatlist);
		Collections.reverse(combatlist);
		return combatlist; 
	}

	public LinkedList<Combat_Player> combatdelete(LinkedList<Combat_Player> combatlist, Combat_Player c) {
		for(int i=0; i<combatlist.size(); i++)
			if(combatlist.get(i).getName().equals(c.getName())){
				combatlist.remove(i); 
				i=combatlist.size(); 
			}
				
		return combatlist;
	}
	public Combat_Player searchPlayer(LinkedList<Combat_Player> clist, String name){
		Combat_Player c=null; 
		boolean cont=true; 
		for(int i = 0; (i< clist.size()) && cont == true; i++){
			if(clist.get(i).getName().equals(name)){
				c=clist.get(i);
				cont=false; 
			}
		}
		return c; 
	}

	public int getIndexOfPlayer(Combat_Player c, LinkedList<Combat_Player> combatlist) {
		return combatlist.lastIndexOf(c);
	}

	public LinkedList<Combat_Player> move_player(Combat_Player c, int position, LinkedList<Combat_Player> combatlist, int movement) {
		
		// UP
		if((position > 0) && movement == UP){
			combatlist.remove(position);
			combatlist.add(position -1, c);
		}
		else if (movement == DOWN && position < (combatlist.size() -1)){
			combatlist.remove(position);
			combatlist.add(position +1, c);
		}
		return combatlist;
	}

}
