package network.gsm.guice;

import network.gsm.patterns.Plan;
import network.gsm.patterns.PlanFactory;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;

public class InjectorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Injector injector = Guice.createInjector(new NetworkModule());
		PlanFactory p = injector.getInstance(PlanFactory.class);
		System.out.println(p);
	}

}
