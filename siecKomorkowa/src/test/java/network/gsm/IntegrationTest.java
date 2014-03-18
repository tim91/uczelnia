package network.gsm;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.Assert;
import network.gsm.Network.Area;
import network.gsm.exception.InvalidAreaException;
import network.gsm.exception.InvalidMessageException;
import network.gsm.exception.InvalidPhoneNumberException;

import org.junit.Test;

public class IntegrationTest {

//	ArrayList<String> smsData = new ArrayList<String>() {{
//	    add("aaaaaaaaaaa");
//	    add("aaaaaaaaaa");
//	    add("C");
//	}}
	
	@Test
	public void integrationTest(){
		try {
			Telephone htc = new Telephone("353453454");
			
			Assert.assertEquals("353453454", htc.getNumber());
			
			Network net = new PolishNetwork("WielkopolskaSiec", 0.1f, 0.01f,0.02f, Area.PL_WIELKOPOLSKA);
			
			htc.setNetwork(net);
			
			Message m = new SMSMessage("258654125", Area.PL_MAZOWSZE, "aaaaaaaaaaa");
			
			htc.sendMessage(m);
			
			Assert.assertEquals(0.3f, m.getCost());
			
			m = new SMSMessage("258654125", Area.PL_MAZOWSZE, "aaaaaaaaaa");
				
			htc.sendMessage(m);
			
			Assert.assertEquals(0.2f, m.getCost());
			
			
			m = new SMSMessage("258654125", Area.PL_MAZOWSZE, "aaaaaa");
			
			htc.sendMessage(m);
			
			Assert.assertEquals(0.2f, m.getCost());
			
			
			m = new SMSMessage("258654125", Area.PL_MAZOWSZE, "aaaaa");
			
			htc.sendMessage(m);
			
			Assert.assertEquals(0.1f, m.getCost());
			
			m = new SMSMessage("258654125", Area.PL_MAZOWSZE, "a");
			
			htc.sendMessage(m);
			
			Assert.assertEquals(0.1f, m.getCost());
			
			
			m = new SMSMessage("258654125", Area.PL_MAZOWSZE, "");
			
			htc.sendMessage(m);
			
			Assert.assertEquals(0.1f, m.getCost());
			
			
			m = new SMSMessage("258654125", Area.PL_MAZOWSZE, "sdfsdfsdfs");
			
			htc.sendMessage(m);
			
			System.out.println("Cost : " + htc.getBillingCost());
			
			net = new FreeSMS(net, Area.PL_MAZOWSZE);
			
			htc.setNetwork(net);
			
			m = new SMSMessage("258654125", Area.PL_MAZOWSZE, "sdfsdfsdfs");
			
			htc.sendMessage(m);
			
			System.out.println("Cost : " + htc.getBillingCost());
			
			m = new SMSMessage("258654125", Area.PL_POMORZE, "sdfsdfsdfs");
			
			htc.sendMessage(m);
			
			System.out.println("Cost : " + htc.getBillingCost());
			
			net = new FreeSMS(net, new Area[]{Area.PL_MAZOWSZE,Area.PL_POMORZE});
			
			htc.setNetwork(net);
			
			m = new SMSMessage("258654125", Area.PL_POMORZE, "sdfsdfsdfs");
			
			htc.sendMessage(m);
			
			System.out.println("Cost : " + htc.getBillingCost());
			
			m = new CallMessage("258654125", Area.PL_POMORZE, 1,20);
			
			htc.sendMessage(m);
			
			System.out.println("Cost : " + htc.getBillingCost());
			
			System.out.println("----------------------");
			System.out.println("History : \n");
			
			Collection<Message> msgs = htc.getBilling();
			
			for (Message message : msgs) {
				System.out.println(message.getCost());
			}
			
			System.out.println("Bill cost : " + htc.getBillingCost());
			
		} catch (InvalidPhoneNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (InvalidMessageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAreaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
