package network.gsm;

import network.gsm.Network.Area;

public class SMSMessage extends Message {

	/*
	 * Dlugosc sms'a
	 */
	private static final float smsSize = (float) 5.0;
	
	private String smsContent;
	
	public SMSMessage(String sender, String receiver, Area receiverArea,String smsContent) {
		super(sender, receiver,receiverArea);
		
		this.smsContent = smsContent;
	}

	@Override
	public float getUnits() {
		// TODO Auto-generated method stub
		return (float) Math.ceil(this.smsContent.length() / smsSize);
	}

}
