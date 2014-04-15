package network.gsm.patterns;

public class PDFReport extends ReportCreator {

	public void visit(VoiceConnectionHistory vc) {
		// TODO Auto-generated method stub
		
		/*
		 * Tutaj przetwarzamy dane dla polaczen glosowych
		 */
		
	}

	public void visit(SMSConnectionHistory sc) {
		// TODO Auto-generated method stub
		
		/*
		 * Tutaj przetwarzamy dane, ktore dotycza sms'ow
		 */
		
	}

	public void visit(InternetConnectionHistory ic) {
		// TODO Auto-generated method stub
		
		/*
		 * Tutaj przetwarzamy dane dotyczace polaczen z internetem
		 */
		
	}

	@Override
	public void generateReportPartForVoiceConnections() {
		// TODO Auto-generated method stub
		historyConnectionManager.getVoiceConnectionHistory().accept(this);
	}

	@Override
	public void generateReportPartForSMSConnection() {
		// TODO Auto-generated method stub
		historyConnectionManager.getSmsConnectionHistory().accept(this);
	}

	@Override
	public void generateReportPartForInternetConnections() {
		// TODO Auto-generated method stub
		historyConnectionManager.getInternetConnectionHistory().accept(this);
	}

}
