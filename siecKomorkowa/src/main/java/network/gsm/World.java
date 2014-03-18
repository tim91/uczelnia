package network.gsm;

import java.util.Collection;

import network.gsm.Network.Area;
import network.gsm.exception.InvalidAreaException;
import network.gsm.exception.InvalidMessageException;
import network.gsm.exception.InvalidPhoneNumberException;

/**
 * Hello world!
 *
 */
public class World 
{
    public static void main( String[] args )
    {
    	try {
			Telephone htc = new Telephone("353453454");
			
			Network net = new PolishNetwork("WielkopolskaSiec", 0.5f, 0.4f,0.05f, Area.PL_WIELKOPOLSKA);
			
			htc.setNetwork(net);
			
			Message m = new SMSMessage("258654125", Area.PL_MAZOWSZE, "sdfsdfsdfsdf");
			
			htc.sendMessage(m);
			
			System.out.println("Cost : " + htc.getBillingCost());
			
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
