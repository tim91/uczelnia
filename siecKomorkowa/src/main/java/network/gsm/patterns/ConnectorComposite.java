package network.gsm.patterns;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConnectorComposite implements Connector{

	List<Connector> connectors = new ArrayList<Connector>();
	
	Set<Number> knownNumbers = new HashSet<Number>();
	
	public void send(String message, Receiver colleague) {
		
		/*
		 * Przeszukuje numery
		 */
		
		/*
		 * Jeżeli ja posiadam numer to wysylam
		 */
		colleague.send(message);
		
		/*
		 * W przeciwnym wypadku
		 */
		for(Connector c : connectors){
			/*
			 * Przeszukuje, na konektorze ktory zna dana siec,numer
			 */
			c.send(message, colleague);
		}
	}
	

	public void add(Connector con){
		this.connectors.add(con);
	}
	
	public void remove(Connector con){
		this.connectors.remove(con);
	}
}
