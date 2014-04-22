package network.gsm;

import junit.framework.Assert;
import network.gsm.Network.Area;
import network.gsm.exception.InvalidAreaException;
import network.gsm.exception.InvalidMessageException;
import network.gsm.exception.InvalidPhoneNumberException;

import org.junit.Test;

public class TelephoneTest {

	@Test
	public void telephoneTest(){
		
		try {
			Telephone t = new Telephone("215487568");
		} catch (InvalidPhoneNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Telephone t = new Telephone("21548758");
		} catch (InvalidPhoneNumberException e) {
			// TODO Auto-generated catch block
			Assert.assertTrue(true);
			Assert.assertEquals("Invalid phone number", e.getMessage());
		}
		
		Telephone t;
		try {
			t = new Telephone("234567890");
			t.sendMessage(null);
		} catch (InvalidPhoneNumberException e) {
			// TODO Auto-generated catch block
			Assert.assertTrue(false);
		} catch (InvalidMessageException e) {
			// TODO Auto-generated catch block
			Assert.assertTrue(true);
			Assert.assertEquals("Message object is null", e.getMessage());
		}
		
		try {
			t = new Telephone("234567890");
			t.sendMessage(new SMSMessage(null, Area.PL_MAZOWSZE, "sdfsdf"));
		} catch (InvalidPhoneNumberException e) {
			// TODO Auto-generated catch block
			Assert.assertTrue(true);
			Assert.assertEquals("Invalid receiver phone number!", e.getMessage());
		} catch (InvalidMessageException e) {
			// TODO Auto-generated catch block
			Assert.assertTrue(false);
			Assert.assertEquals("Message object is null", e.getMessage());
		} catch (InvalidAreaException e) {
			// TODO Auto-generated catch block
			Assert.assertTrue(false);
		}
		
	}
}
