package network.gsm.guice;

import javax.inject.Singleton;

import network.gsm.patterns.ConnectionHistory;
import network.gsm.patterns.ConnectionVistator;
import network.gsm.patterns.InternetConnectionHistory;
import network.gsm.patterns.InternetData;
import network.gsm.patterns.InternetPackage;
import network.gsm.patterns.Plan;
import network.gsm.patterns.PlanFactory;
import network.gsm.patterns.PlanFreeSMS;
import network.gsm.patterns.PlanOrange;
import network.gsm.patterns.PlanPlus;
import network.gsm.patterns.ReportCreator;
import network.gsm.patterns.SMSConnectionHistory;
import network.gsm.patterns.VoiceConnectionHistory;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class NetworkModule extends AbstractModule {

	@Override
	protected void configure() {
		
		bind(InternetData.class).annotatedWith(Names.named("InternetPackage")).to(InternetPackage.class);
		bind(ConnectionHistory.class).annotatedWith(Names.named("InternetConnectionHistory")).to(InternetConnectionHistory.class);
		bind(ConnectionHistory.class).annotatedWith(Names.named("SMSConnectionHistory")).to(SMSConnectionHistory.class);
		bind(ConnectionHistory.class).annotatedWith(Names.named("VoiceConnectionHistory")).to(VoiceConnectionHistory.class);
		bind(ConnectionVistator.class).annotatedWith(Names.named("ReportCreator")).to(ReportCreator.class);
		bind(PlanFactory.class).to(PlanFactory.class).in(Singleton.class);
	}

}
