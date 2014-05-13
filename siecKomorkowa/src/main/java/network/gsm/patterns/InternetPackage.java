package network.gsm.patterns;

public class InternetPackage implements InternetData {

	private float costFor100k = 0;
	private char[] data;
	
	public InternetPackage(float costFor100k) {
		
		this.costFor100k = costFor100k;
	}
	
	public InternetPackage() {
	}
}
