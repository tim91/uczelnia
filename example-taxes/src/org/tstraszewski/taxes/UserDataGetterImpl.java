package org.tstraszewski.taxes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserDataGetterImpl implements UserDataGetter {

	private InputStreamReader isr = null;
	private BufferedReader br = null;
	
	public UserDataGetterImpl() {
		isr = new InputStreamReader(System.in);
		br = new BufferedReader(isr);
	}
	
	@Override
	public char getUmowa() throws IOException {
		System.out.print("Typ umowy: (P)raca, (Z)lecenie: ");
		return br.readLine().charAt(0);
			
	}

	@Override
	public double getPodstawa() throws NumberFormatException, IOException {
		System.out.print("Podaj kwotÄ™ dochodu: ");	
		return Double.parseDouble(br.readLine());
	}

	@Override
	public void releaseResources() {
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
