package network.gsm;


public class PolishNetwork extends Network {

	
	public PolishNetwork(String name, float smsCost, float callCost, Area area) {

		super.setName(name);
		super.setSmsCost(smsCost);
		super.setCallCost(callCost);
		super.setArea(area);
	}
	
	@Override
	public float calculateCost(Message m) {
		
		float units = m.getUnits();
		
		if(m instanceof SMSMessage){
			/*
			 * Jednostka jest ilosc sms'ow
			 */
			return getSmsCost() * units;
		}
		else if(m instanceof PhoneMessage){
			/*
			 * Jednostka jest czas w sekundach
			 */
			return getCallCost() * units;
		}
		return -1;
	}

}
