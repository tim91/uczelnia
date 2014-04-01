package network.gsm;

public class BlockNumber implements IOperation {


	private String number;
	public BlockNumber(String number) {
		this.number = number;
	}
	
	public void invokeOperation() {
		// TODO Auto-generated method stub
		System.out.println("Blokuje numer.... " + this.number);
	}

}
