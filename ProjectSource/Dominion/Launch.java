package Dominion;




public class Launch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dice d8 = new Dice(20); 
		for(int i = 0; i<100; i++)
		System.out.print(" Result: "+ d8.throwDices(1)); 
		
		
	}
		

}
