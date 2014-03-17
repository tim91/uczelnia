package network.gsm;

import network.gsm.Network.Area;
import network.gsm.exception.InvalidPhoneNumberException;
import network.gsm.exception.UnknownReceiverException;

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
			
			Network net = new PolishNetwork("WielkopolskaSiec", 0.5f, 0.4f, Area.PL_WIELKOPOLSKA);
			
			htc.setNetwork(net);
			
			Message m = new SMSMessage("258654125", Area.PL_MAZOWSZE, "sdfsdfsdfsdf");
			
			htc.sendMessage(m);
			
			System.out.println("Cost : " + htc.getBillingCost());
			
			m = new SMSMessage("258654125", Area.PL_MAZOWSZE, "sdfsdfsdfs");
			
			htc.sendMessage(m);
			
			System.out.println("Cost : " + htc.getBillingCost());
			
			net = new FreeSMS(net, Area.PL_MAZOWSZE);
			
			htc.setNetwork(net);
			
			htc.sendMessage(m);
			
			System.out.println("Cost : " + htc.getBillingCost());
			
			m = new SMSMessage("258654125", Area.PL_POMORZE, "sdfsdfsdfs");
			
			htc.sendMessage(m);
			
			System.out.println("Cost : " + htc.getBillingCost());
			
		} catch (InvalidPhoneNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownReceiverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
