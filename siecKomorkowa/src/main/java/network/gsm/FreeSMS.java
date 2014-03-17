package network.gsm;

public class FreeSMS extends Network {

	private Network network;
	
	private Area[] freeArea;
	
	public FreeSMS(Network n, Area ... a) {
		this.network = n;
		this.freeArea = a;
	}
	
	@Override
	protected float calculateCost(Message m) {
		
		float cost = this.network.calculateCost(m);
		
		for (Area fa : this.freeArea) {
			/*
			 * Odbiorca jest w sieci do której mamy darmowe sms'y
			 */
			if(fa == m.getReceiverArea())
				return 0;
		}

		return cost;
	}

}
