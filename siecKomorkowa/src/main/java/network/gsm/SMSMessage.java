package network.gsm;

import network.gsm.Network.Area;
import network.gsm.exception.InvalidPhoneNumberException;

public class SMSMessage extends Message {

	/*
	 * Dlugosc sms'a
	 */
	private static final float smsSize = 5.0f;
	
	private String smsContent;
	
	public SMSMessage(String receiver, Area receiverArea,String smsContent) throws InvalidPhoneNumberException {
		super(receiver,receiverArea);
		
		this.smsContent = smsContent;
	}

	@Override
	public float getUnits() {
		// TODO Auto-generated method stub
		return (float) Math.ceil(this.smsContent.length() / smsSize);
	}

}
