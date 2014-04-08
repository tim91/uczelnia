package network.gsm.patterns;

public class PlanOragne implements Plan {

	private float smsCost = 0.2f;
	private float callCost = 0.1f;
	private float internetDataCost = 0.3f;
	
	
	public float sendSms() {
		// TODO Auto-generated method stub
		return smsCost;
	}

	public float call() {
		// TODO Auto-generated method stub
		return callCost;
	}

	public float downloadData() {
		// TODO Auto-generated method stub
		return internetDataCost;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

}
