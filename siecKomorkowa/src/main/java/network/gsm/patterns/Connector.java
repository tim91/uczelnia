package network.gsm.patterns;

/*
 * Implementation of mediator pattern
 */
public interface Connector {
	public void send(String message, Receiver colleague);
}
