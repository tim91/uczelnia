package network.gsm.patterns;

public class SMSConnectionHistory implements ConnectionHistory{

	public void accept(ConnectionVistator connectionVisitor) {
		connectionVisitor.visit(this);
	}

	
}
