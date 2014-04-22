package network.gsm;

public class RegisterNumber implements IOperation {

	
	private String number;
	public RegisterNumber(String number) {
		this.number = number;
	}
	
	public void invokeOperation() {
		// TODO Auto-generated method stub
		
		System.out.println("Rejestruje numer... " + this.number);
		
	}

}
