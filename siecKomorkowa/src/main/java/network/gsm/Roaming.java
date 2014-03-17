package network.gsm;

public class Roaming extends Network {

	private Network network = null;

	private float percentageProvision;

	public Roaming(Network network, float roamingPercentageProvision) {
		super();
		this.network = network;
		this.percentageProvision = roamingPercentageProvision;
	}

	@Override
	public float calculateCost(Message m) {

		float x = -1;
		x = this.network.calculateCost(m);
		
		if(x == 0){
			/*
			 * Mam darmowe polaczenia do sieci docelowej
			 */
			return this.percentageProvision * 10;
		}
			
					
		return x + x * this.percentageProvision;

	}

}
