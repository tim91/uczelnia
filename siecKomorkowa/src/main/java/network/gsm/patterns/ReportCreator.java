package network.gsm.patterns;

public abstract class ReportCreator implements ConnectionVistator {

	protected HistoryConnectionManager historyConnectionManager;
	
	public ReportCreator() {
		this.historyConnectionManager = HistoryConnectionManager.getInstance();
	}
	
	
	public final void buildReport(){
	
		generateReportForVoiceConnections();
		generateReportForSMSConnection();
		generateReportForInternetConnections();
		
	}
	
	public abstract void generateReportForVoiceConnections();
	public abstract void generateReportForSMSConnection();
	public abstract void generateReportForInternetConnections();
	
}
