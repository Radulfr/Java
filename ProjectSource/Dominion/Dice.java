package Dominion;

public class Dice {
	private int faces;

	public Dice(int faces){
		setFaces(faces);  
	}
	public int getFaces() {
		return faces;
	}

	public void setFaces(int faces) {
		this.faces = faces;
	}

	public int throwDices(int n_dices){
		int result=0;
		for(int i = 0; i<n_dices; i++){
			result += Math.random()*getFaces() +1; 
		}
		return result;
		
	}
	

}
