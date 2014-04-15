package network.gsm.patterns;

public class HistoryConnectionManager {

	private static HistoryConnectionManager hm = null;
	
	private VoiceConnectionHistory voiceConnectionHistory = null;
	
	private SMSConnectionHistory smsConnectionHistory = null;
	
	private InternetConnectionHistory internetConnectionHistory = null;
	
	private HistoryConnectionManager(){
		
	}
	
	public static HistoryConnectionManager getInstance(){
		
		if(hm == null){
			return new HistoryConnectionManager();
		}
		else{
			return hm;
		}
		
	}

	public VoiceConnectionHistory getVoiceConnectionHistory() {
		return voiceConnectionHistory;
	}

	public SMSConnectionHistory getSmsConnectionHistory() {
		return smsConnectionHistory;
	}

	public InternetConnectionHistory getInternetConnectionHistory() {
		return internetConnectionHistory;
	}
	
}
