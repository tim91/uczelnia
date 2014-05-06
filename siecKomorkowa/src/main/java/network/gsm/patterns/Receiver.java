package network.gsm.patterns;

import network.gsm.Network;

/*
 * Implementacja mediatora
 * http://java.dzone.com/articles/design-patterns-mediator
 */
public abstract class Receiver {
	
	Connector connector;
	Network network;

	public Receiver(Connector m) {
		this.connector = m;
	}
	
	// send a message via the mediator
	public void send(String message) {
		connector.send(message, this);
	}

	// get access to the mediator
	public Connector getMediator() {
		return connector;
	}

	
	
	public abstract void receive(String message);

}
