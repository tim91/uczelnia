package network.gsm.patterns;

import java.util.HashMap;
import java.util.Map;

public class PlanFactory {
	
	public static String PLAN_FREE_SMS = "plan_free_sms";
	public static String PLAN_PLUS = "plan_plus";
	public static String PLAN_ORANGE = "plan_orange";
	
	private static Map<String,Plan> planContainer = new HashMap<String,Plan>();
	
	
	static
	{
		planContainer.put(PLAN_ORANGE, new PlanOragne());
		planContainer.put(PLAN_PLUS, new PlanPlus());
		
		new PlanFreeSMS(new PlanOragne(), 500);
	}
	
	
	public void addPlan(String key, Plan plan){
		planContainer.put(key, plan);
	}
	
	public Plan getPlan(String key){
		
		try {
			return (Plan) this.planContainer.get(key).clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
