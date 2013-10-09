package Dominion;

public class Player extends User{
	private String name; 
	private String playerClass;
	private int level; 
	private int xPoints;
	
	public Player(String name, String playerClass, int level, int xPoints) {

		this.name = name;
		this.playerClass = playerClass;
		this.level = level;
		this.xPoints = xPoints;
	}
	@Override
	public String toString() {
		return "Player [name=" + name + ", playerClass=" + playerClass
				+ ", level=" + level + ", xPoints=" + xPoints + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlayerClass() {
		return playerClass;
	}
	public void setPlayerClass(String playerClass) {
		this.playerClass = playerClass;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getxPoints() {
		return xPoints;
	}
	public void setxPoints(int xPoints) {
		this.xPoints = xPoints;
	}

	
}
