package network.gsm.patterns;

public class InternetConnectionHistory implements ConnectionHistory {

	public void accept(ConnectionVistator connectionVisitor) {
		connectionVisitor.visit(this);
	}

}
