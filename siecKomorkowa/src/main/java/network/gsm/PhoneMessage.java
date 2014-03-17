package network.gsm;

import network.gsm.Network.Area;

public class PhoneMessage extends Message {

	private float callDuration;
	
	public PhoneMessage(String sender, String receiver, Area receiverArea, int min, int sec) {
		super(sender, receiver,receiverArea);
		
		this.callDuration = min*60 + sec;
	}

	@Override
	public float getUnits() {
		// TODO Auto-generated method stub
		return this.callDuration;
	}

}
