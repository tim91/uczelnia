package network.gsm.patterns;

public interface ConnectionVistator {

	public void visit(VoiceConnectionHistory vc);
	public void visit(SMSConnectionHistory sc);
	public void visit(InternetConnectionHistory ic);
}
