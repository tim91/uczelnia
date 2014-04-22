package network.gsm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import network.gsm.exception.InvalidMessageException;
import network.gsm.exception.InvalidPhoneNumberException;

public class Telephone {

	private List<Message> billing = new ArrayList<Message>();

	private float billingCost;

	private Network network;

	private String number;

	
	public Telephone(String number) throws InvalidPhoneNumberException {
		super();
		setNumber(number);
	}

	public Telephone(Network network, String number) throws InvalidPhoneNumberException {
		super();
		this.network = network;
		setNumber(number);
	}

	public void sendMessage(Message message) throws InvalidMessageException {

		if(message == null)
			throw new InvalidMessageException("Message object is null");
			
		if(message.getSender() == null){
			message.setSender(this.number);
		}
		
		Message m = network.sendMessage(message);
		this.billing.add(m);
		recountBillingCost(m.getCost());
		System.out.println("Message send to: " + message.getReceiver() + " message type: " + message.getClass().getCanonicalName());
	}

	private void recountBillingCost(float cost) {
		this.billingCost += cost;
	}

	public Network getNetwork() {
		return network;
	}

	public Collection<Message> getBilling() {
		return Collections.unmodifiableCollection(billing);
	}

	public float getBillingCost() {
		return billingCost;
	}

	public void setNetwork(Network network) {
		this.network = network;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) throws InvalidPhoneNumberException {
		
		if(number == null || number.length() != 9)
			throw new InvalidPhoneNumberException("Invalid phone number");
		
		this.number = number;
	}

	public void payTheBill() {
		this.billingCost = 0f;
	}
}
