package network.gsm;

import network.gsm.Network.Area;
import network.gsm.exception.InvalidAreaException;
import network.gsm.exception.InvalidMessageException;
import network.gsm.exception.InvalidPhoneNumberException;

public class DataMessage extends Message {

	private String message;
	
	private float dataLength = 5.0f;
	
	public DataMessage(String receiver, Area receiverArea, String data)
			throws InvalidPhoneNumberException, InvalidMessageException, InvalidAreaException {
		super(receiver, receiverArea);
		
		if(data == null)
			throw new InvalidMessageException("Data content is null");
		
		this.message = data;
	}

	@Override
	public float getUnits() {
		return (float) Math.ceil(this.message.getBytes().length / dataLength);
	}
}
