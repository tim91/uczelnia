package com.bartoszwalter.students.taxes;

import java.io.IOException;

public interface UserDataGetter {
	
	public char getUmowa() throws IOException;
	public double getPodstawa() throws NumberFormatException, IOException;
	public void releaseResources();

}
