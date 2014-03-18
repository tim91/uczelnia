package network.gsm;


public class PolishNetwork extends Network {

	/**
	 * 
	 * @param name Network name
	 * @param smsCost cost for one sms
	 * @param callCost cost for one second of call
	 * @param dataTransferCost cost for transfer 10 bytes of data
	 * @param area area of this network
	 */
	public PolishNetwork(String name, float smsCost, float callCost, float dataTransferCost, Area area) {

		super.setName(name);
		super.setSmsCost(smsCost);
		super.setCallCost(callCost);
		super.setDataTransferCost(dataTransferCost);
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
		else if(m instanceof CallMessage){
			/*
			 * Jednostka jest czas w sekundach
			 */
			return getCallCost() * units;
		}
		else if(m instanceof DataMessage){
			/*
			 * Jednostka jest ilosc paczek po 10 bajtow
			 */
			return getDataTransferCost() * units;
		}
		return -1;
	}

}
