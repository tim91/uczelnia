package network.gsm;

import network.gsm.Network.Area;
import network.gsm.exception.InvalidPhoneNumberException;

public class PhoneMessage extends Message {

	private float callDuration;
	
	public PhoneMessage(String receiver, Area receiverArea, int min, int sec) throws InvalidPhoneNumberException {
		super(receiver,receiverArea);
		
		this.callDuration = min*60 + sec;
	}

	@Override
	public float getUnits() {
		// TODO Auto-generated method stub
		return this.callDuration;
	}

}
