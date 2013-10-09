package AppActions;


import Dominion.Dice; 
import com.opensymphony.xwork2.ActionSupport;

public class Dices extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nd4;
	private String nd6; 
	private String nd8;
	private String nd10; 
	private String nd12; 
	private String nd20; 
	private Dice dic; 
	private String result="0"; 
	private int selector; 
	private String operation=""; 
	

	public Dice getDic() {
		return dic;
	}

	public void setDic(Dice dic) {
		this.dic = dic;
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

	public String diceThrow() {
		int n_dices=1; 
		
		try {
			switch(selector){
				case 4:
					setDic(new Dice(4)); 
					n_dices = Integer.parseInt(getNd4());
					setOperation("["+n_dices+"d4]");
					break;
				case 6:
					setDic(new Dice(6)); 
					n_dices = Integer.parseInt(getNd6());
					setOperation("["+n_dices+"d6]");
					break;
				case 8:
					setDic(new Dice(8)); 
					n_dices = Integer.parseInt(getNd8());
					setOperation("["+n_dices+"d8]");
					break;
				case 10:
					setDic(new Dice(10)); 
					n_dices = Integer.parseInt(getNd10());
					setOperation("["+n_dices+"d10]");
					break;
				case 12:
					setDic(new Dice(12)); 
					n_dices = Integer.parseInt(getNd12());
					setOperation("["+n_dices+"d12]");
					break;
				case 20:
					setDic(new Dice(20)); 
					n_dices = Integer.parseInt(getNd20());
					setOperation("["+n_dices+"d20]");
					break;
			}
			setResult(dic.throwDices(n_dices)); 
			System.gc();
			return SUCCESS; 
		}
		catch (Exception e) {
			return ERROR;
		}
	}

	public String getNd4() {
		return nd4;
	}


	public void setNd4(String nd4) {
		this.nd4 = nd4;
	}


	public String getNd6() {
		return nd6;
	}


	public void setNd6(String nd6) {
		this.nd6 = nd6;
	}


	public String getNd8() {
		return nd8;
	}


	public void setNd8(String nd8) {
		this.nd8 = nd8;
	}


	public String getNd10() {
		return nd10;
	}


	public void setNd10(String nd10) {
		this.nd10 = nd10;
	}


	public String getNd12() {
		return nd12;
	}


	public void setNd12(String nd12) {
		this.nd12 = nd12;
	}


	public String getNd20() {
		return nd20;
	}


	public void setNd20(String nd20) {
		this.nd20 = nd20;
	}

	public String getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result +"";
	}

	public int getSelector() {
		return selector;
	}

	public void setSelector(int selector) {
		this.selector = selector;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
	
}
