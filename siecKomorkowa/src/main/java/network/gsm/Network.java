package network.gsm;

public abstract class Network {

	public static enum Area {
		 PL_WIELKOPOLSKA, PL_MAZOWSZE, PL_POMORZE, PL_SLASK
		}

	private String name;
	
	private float smsCost;
	
	private float callCost;
	
	private Area area;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSmsCost() {
		return smsCost;
	}

	public void setSmsCost(float smsCost) {
		this.smsCost = smsCost;
	}

	public float getCallCost() {
		return callCost;
	}

	public void setCallCost(float callCost) {
		this.callCost = callCost;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	
	protected abstract float calculateCost(Message m);
	
	public Message sendMessage(Message m) {
		
		float cost = calculateCost(m);
		
		m.setCost(cost);
		
		return m;
		
	}
	
}
