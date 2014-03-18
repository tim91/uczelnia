package network.gsm;

import network.gsm.Network.Area;
import network.gsm.exception.InvalidAreaException;
import network.gsm.exception.InvalidMessageException;
import network.gsm.exception.InvalidPhoneNumberException;

public class CallMessage extends Message {

	private float callDuration;
	
	public CallMessage(String receiver, Area receiverArea, int min, int sec) throws InvalidPhoneNumberException, InvalidMessageException, InvalidAreaException {
		super(receiver,receiverArea);
		
		if(min < 0 || sec < 0){
			throw new InvalidMessageException("Call duration is invalid");
		}
		
		this.callDuration = min*60 + sec;
	}

	@Override
	public float getUnits() {
		// TODO Auto-generated method stub
		return this.callDuration;
	}

}
