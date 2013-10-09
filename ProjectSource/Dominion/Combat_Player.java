package Dominion;

public class Combat_Player extends Player implements Comparable<Object>{

	private int initiative;
	public int getHitpoints() {
		return hitpoints;
	}

	public void setHitpoints(int hitpoints) {
		this.hitpoints = hitpoints;
		
		
	}

	private int hitpoints;
	
	public Combat_Player(String name, String playerClass, int level, int xPoints) {
		super(name, playerClass, level, xPoints);
		this.hitpoints=0; 

	}

	public int getInitiative() {
		return initiative;
	}

	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}
	

	public int compareTo(Combat_Player c){
		/*
		 * a.compareTo(b)
		 * a<=b: -1
		 * a>b :  1
		 */		
		int result = 0;
		if(this.getInitiative()<= c.getInitiative())
			result=-1; 
		else
			result = 0; 
		
		return result; 
	}

	@Override
	public String toString() {
		return " [initiative=" + initiative + "]";
	}

	@Override
	public int compareTo(Object o) {
		int valor=0; 
		if(( o instanceof Combat_Player) == true  && this != o){
			Combat_Player nod = (Combat_Player) o;
			
			if( nod.getInitiative() <= this.getInitiative())
				valor= 1;
			else if (nod.getInitiative() == this.getInitiative())
				valor= 0;
			else
				valor= -1;
		}
		return valor;
	}

}
