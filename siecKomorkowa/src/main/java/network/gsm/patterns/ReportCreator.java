package network.gsm.patterns;

public abstract class ReportCreator implements ConnectionVistator {

	protected HistoryConnectionManager historyConnectionManager;
	
	public ReportCreator() {
		this.historyConnectionManager = HistoryConnectionManager.getInstance();
	}
	
	
	public final void buildReport(){
	
		generateReportPartForVoiceConnections();
		generateReportPartForSMSConnection();
		generateReportPartForInternetConnections();
		
	}
	
	public abstract void generateReportPartForVoiceConnections();
	public abstract void generateReportPartForSMSConnection();
	public abstract void generateReportPartForInternetConnections();
	
}
