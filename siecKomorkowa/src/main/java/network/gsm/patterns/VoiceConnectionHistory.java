package network.gsm.patterns;

public class VoiceConnectionHistory implements ConnectionHistory {

	public void accept(ConnectionVistator connectionVisitor) {
		connectionVisitor.visit(this);
		
	}

}
