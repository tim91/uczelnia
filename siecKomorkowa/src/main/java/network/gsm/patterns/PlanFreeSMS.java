package network.gsm.patterns;

import com.google.inject.Inject;

public class PlanFreeSMS implements Plan {

	private Plan plan = null;
	private int freeSms = 0;
	
	public PlanFreeSMS() {
		// TODO Auto-generated constructor stub
	}
	
	@Inject
	public PlanFreeSMS(Plan plan, int freeSms) {
		this.plan = plan;
		this.freeSms = freeSms;
	}
	
	public float sendSms() {
		
		if(freeSms > 0){
			/*
			 * Zmniejszamy liczbe darmowych sms'ow
			 */
			freeSms--;
			return 0;
		}else{
			return this.plan.sendSms();
		}
		
	}

	public float call() {
		return this.plan.call();

	}

	public float downloadData() {
		return this.plan.downloadData();

	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

}
