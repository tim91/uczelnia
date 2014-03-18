package network.gsm;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import network.gsm.Network.Area;
import network.gsm.exception.InvalidAreaException;
import network.gsm.exception.InvalidMessageException;
import network.gsm.exception.InvalidPhoneNumberException;

import org.junit.Test;

public class MessageTest {

	@Test
	public void messageTest(){
		
		List<Parameter> params = new ArrayList<Parameter>();
		
		params.add(new Parameter("548741258",Area.PL_MAZOWSZE,"sdfsdf"));
		
		try {
			
			Message m = new SMSMessage("548741258", Area.PL_MAZOWSZE, "sdfsdf");
			Assert.assertEquals("548741258", m.getReceiver());
			Assert.assertNull(m.getSender());
			Assert.assertEquals(-1, m.getCost(), 0);
			
		} catch (InvalidPhoneNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidMessageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAreaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Message m = new SMSMessage("548741258", Area.PL_MAZOWSZE, null);
		} catch (InvalidPhoneNumberException e) {
			// TODO Auto-generated catch block
			Assert.assertTrue(false);
		} catch (InvalidMessageException e) {
			Assert.assertTrue(true);
		} catch (InvalidAreaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Message m = new SMSMessage("54741258", Area.PL_MAZOWSZE, "sdfsdf");
		} catch (InvalidPhoneNumberException e) {
			// TODO Auto-generated catch block
			Assert.assertTrue(true);
		} catch (InvalidMessageException e) {
			Assert.assertTrue(false);
		} catch (InvalidAreaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Message m = new SMSMessage("54741258", Area.PL_MAZOWSZE, null);
		} catch (InvalidPhoneNumberException e) {
			// TODO Auto-generated catch block
			Assert.assertTrue(true);
		} catch (InvalidMessageException e) {
			Assert.assertTrue(false);
		} catch (InvalidAreaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Message m = new SMSMessage("54741258", null, null);
		} catch (InvalidPhoneNumberException e) {
			// TODO Auto-generated catch block
			Assert.assertTrue(true);
		} catch (InvalidMessageException e) {
			Assert.assertTrue(false);
		} catch (InvalidAreaException e) {
			// TODO Auto-generated catch block
			Assert.assertTrue(false);
		}
		
		try {
			Message m = new SMSMessage("547412508", null, "");
		} catch (InvalidPhoneNumberException e) {
			// TODO Auto-generated catch block
			Assert.assertTrue(false);
		} catch (InvalidMessageException e) {
			Assert.assertTrue(false);
		} catch (InvalidAreaException e) {
			// TODO Auto-generated catch block
			Assert.assertTrue(true);
		}
		
	}
	
	private class Parameter{
		
		private String receiver;
		private Area receiverArea;
		private String messageContent;
		
		public Parameter(String receiver, Area receiverArea,
				String messageContent) {
			super();
			this.receiver = receiver;
			this.receiverArea = receiverArea;
			this.messageContent = messageContent;
		}
	}
}
