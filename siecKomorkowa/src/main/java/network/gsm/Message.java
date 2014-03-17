package network.gsm;

import network.gsm.Network.Area;
import network.gsm.exception.InvalidPhoneNumberException;

public abstract class Message {
	
	private String sender;
	
	private String receiver;
	
	private Area receiverArea;
	
	private float cost;
	
	/*
	 * Metoda zwraca liczbe jednostek, ktore podlegaja oplacie
	 * np. ilosc sms'ow, slugosc rozmowy
	 */
	public abstract float getUnits();
	
	public Message(String receiver, Area receiverArea) throws InvalidPhoneNumberException {
		super();
		setReceiver(receiver);
		this.receiverArea = receiverArea;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) throws InvalidPhoneNumberException {
		if(receiver.length() != 9)
			throw new InvalidPhoneNumberException("Invalid receiver phone number!");
		
		this.receiver = receiver;
	}

	public Area getReceiverArea() {
		return receiverArea;
	}

	public void setReceiverArea(Area receiverArea) {
		this.receiverArea = receiverArea;
	}
	
	
	
	
}
