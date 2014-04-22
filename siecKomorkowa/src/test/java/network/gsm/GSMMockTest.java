package network.gsm;

import static org.junit.Assert.assertEquals;
import network.gsm.exception.InvalidMessageException;
import network.gsm.exception.InvalidPhoneNumberException;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.auto.Mock;
import org.junit.Test;

public class GSMMockTest {
	
	private Mockery context;
	
	private Telephone htc;
	
	private Network network;
	private CallMessage call;
	
	@Test
	public void firstMock(){
		
		context = new Mockery();
		
		try {
			htc = new Telephone("258413658");
			
			network = context.mock(Network.class, "p1");
			
			call = context.mock(CallMessage.class, "call");
			
			htc.setNetwork(network);
			
			
			int expectedSum = 299;
			
			context.checking(new Expectations() {{
				allowing(network).getCallCost();
				will(returnValue(0.1));
			}});
			
			context.checking(new Expectations() {{
				allowing(call).getUnits();
				will(returnValue(20));
			}});
			
			context.checking(new Expectations() {{
				allowing(htc).getBillingCost();
				will(returnValue(2));
			}});
			
			try {
				htc.sendMessage(call);
			} catch (InvalidMessageException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			assertEquals(expectedSum, htc.getBillingCost() );
			
			context.assertIsSatisfied();			
			
		} catch (InvalidPhoneNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Mock
	Telephone tel;
	
	@Test
	public void mock2(){
		
		try {
			tel = new Telephone("25487413658");
			
			//tel.
			
		} catch (InvalidPhoneNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//when(tel.getNumber()).thenReturn("25487413658");
		
	}

}
