package network.gsm;

import network.gsm.Network.Area;
import network.gsm.exception.InvalidAreaException;
import network.gsm.exception.InvalidMessageException;
import network.gsm.exception.InvalidPhoneNumberException;

public class SMSMessage extends Message {

	/*
	 * Dlugosc sms'a
	 */
	private static final float smsSize = 5.0f;
	
	private String smsContent;
	
	/**
	 * 
	 * @param receiver
	 * @param receiverArea
	 * @param smsContent sms content, divided by 5, 5 - size of one sms
	 * @throws InvalidPhoneNumberException
	 * @throws InvalidMessageException
	 * @throws InvalidAreaException
	 */
	public SMSMessage(String receiver, Area receiverArea,String smsContent) throws InvalidPhoneNumberException, InvalidMessageException, InvalidAreaException {
		super(receiver,receiverArea);
		
		if(smsContent == null)
			throw new InvalidMessageException("SMS content is null");
		
		this.smsContent = smsContent;
	}

	@Override
	public float getUnits() {
		// TODO Auto-generated method stub
		
		if(this.smsContent.length() == 0)
			return 1;
		
		return (float) Math.ceil(this.smsContent.length() / smsSize);
	}

}
