package org.tstraszewski.taxes.contract;

import java.util.HashMap;
import java.util.Map;

public class ContractFactoryImpl implements ContractFactory {

	
	private static Map<Character,BaseContract> availableContracts = new HashMap<Character, BaseContract>();
	static
	{
		availableContracts.put('P', new EmploymentContract());
		availableContracts.put('Z', new CasualWorkContract());
	}
	
	@Override
	public BaseContract createContract(char c) {
		return availableContracts.get(c);
	}

}
