package network.gsm;

import junit.framework.Assert;
import network.gsm.Network.Area;

import org.junit.Test;

public class NetworkTest {

	@Test
	public void networkTest(){
		
		Network n = new PolishNetwork("test", 0.1f, 0.01f, 0.03f, Area.PL_SLASK);
		
		Assert.assertEquals("test", n.getName());
		Assert.assertEquals(Area.PL_SLASK, n.getArea());
		
		n = new FreeSMS(n, Area.PL_SLASK);
		
		Assert.assertEquals(FreeSMS.class.getCanonicalName(), n.getClass().getCanonicalName());
		
		n = new Roaming(n, 50.0f);
		
		Assert.assertEquals(Roaming.class.getCanonicalName(), n.getClass().getCanonicalName());
		
	}
}
