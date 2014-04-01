package network.gsm;

import network.gsm.Network.Area;

import org.junit.Test;

public class CommandTest {

	@Test
	public void test(){
		
		Network net = new PolishNetwork("Orange", 0.5f, 0.2f, 0.4f, Area.PL_MAZOWSZE);
		
		IOperation op = new BlockNumber("324543543");
		
		net.invokeOperation(op);
		
		op = new RegisterNumber("345654765");
		
		net.invokeOperation(op);
		
	}
}
