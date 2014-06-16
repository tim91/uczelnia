package org.tstraszewski;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingType;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.tstraszewski.taxes.contract.BaseContract;
import org.tstraszewski.taxes.contract.ContractFactory;
import org.tstraszewski.taxes.contract.ContractFactoryImpl;
import org.tstraszewski.taxes.report.StandardTaxReport;
import org.tstraszewski.taxes.report.TaxReportTemplate;
import org.tstraszewski.taxes.report.writer.ArrayListOutputWriter;

import com.bartoszwalter.students.taxes.TaxCalculator;

public class TaxCalculatorTest {

	Map<String,List<String>> goodResults = new HashMap<String, List<String>>();
	
	@Before 
	public void init(){
		
		double kwota = 1000;
		goodResults.put(""+kwota+'P',TaxCalculator.getArrayWithResultsUsingOriginalAlgorithm(kwota, 'P'));
		kwota = 150000;
		goodResults.put(""+kwota+'P',TaxCalculator.getArrayWithResultsUsingOriginalAlgorithm(kwota, 'P'));
		kwota = 100.50;
		goodResults.put(""+kwota+'P',TaxCalculator.getArrayWithResultsUsingOriginalAlgorithm(kwota, 'P'));
		kwota = 0;
		goodResults.put(""+kwota+'P',TaxCalculator.getArrayWithResultsUsingOriginalAlgorithm(kwota, 'P'));
		kwota = -100;
		goodResults.put(""+kwota+'P',TaxCalculator.getArrayWithResultsUsingOriginalAlgorithm(kwota, 'P'));
		kwota = 1000;
		goodResults.put(""+kwota+'Z',TaxCalculator.getArrayWithResultsUsingOriginalAlgorithm(kwota, 'Z'));
		kwota = 134000;
		goodResults.put(""+kwota+'Z',TaxCalculator.getArrayWithResultsUsingOriginalAlgorithm(kwota, 'Z'));
		kwota = 1000.80;
		goodResults.put(""+kwota+'Z',TaxCalculator.getArrayWithResultsUsingOriginalAlgorithm(kwota, 'Z'));
		kwota = -100;
		goodResults.put(""+kwota+'Z',TaxCalculator.getArrayWithResultsUsingOriginalAlgorithm(kwota, 'Z'));
		kwota = -100;
		goodResults.put(""+kwota+'P',TaxCalculator.getArrayWithResultsUsingOriginalAlgorithm(kwota, 'P'));
		kwota = 1000.80;
		goodResults.put(""+kwota+'Y',TaxCalculator.getArrayWithResultsUsingOriginalAlgorithm(kwota, 'Y'));
		kwota = 10.80;
		goodResults.put(""+kwota+'Y',TaxCalculator.getArrayWithResultsUsingOriginalAlgorithm(kwota, 'Y'));
		kwota = 100.20;
		goodResults.put(""+kwota+'Y',TaxCalculator.getArrayWithResultsUsingOriginalAlgorithm(kwota, 'Y'));
		kwota = -100;
		goodResults.put(""+kwota+'Y',TaxCalculator.getArrayWithResultsUsingOriginalAlgorithm(kwota, 'Y'));
	}
	
	@Test
	public void taxTest(){
		
		paramterizedTest(1000, 'P');
		paramterizedTest(150000, 'P');
		paramterizedTest(100.50, 'P');
		paramterizedTest(0, 'P');
		paramterizedTest(-100, 'P');
		paramterizedTest(1000, 'Z');
		paramterizedTest(134000, 'Z');
		paramterizedTest(1000.80, 'Z');
		paramterizedTest(-100, 'Z');
		paramterizedTest(-100, 'P');
		paramterizedTest(1000.80, 'Y');
		paramterizedTest(10.80, 'Y');
		paramterizedTest(100.20, 'Y');
		paramterizedTest(-100, 'Y');
		
		
	}
	
	public void paramterizedTest(double kwota, char typ){
		System.out.println(kwota + " " + typ);
		String k = ""+kwota+typ;
		List<String> goodRes = goodResults.get(k);
		
//		List<String> myRes = TaxCalculator.getArrayWithResults(kwota, typ);
		ContractFactory cf = new ContractFactoryImpl();
		BaseContract bc = cf.createContract(typ);
		if(bc != null)
			bc.setPodstawa(kwota);
		
		ArrayListOutputWriter wr = new ArrayListOutputWriter();
		TaxReportTemplate trt = new StandardTaxReport(bc, wr);
		trt.createReport();
		
		List<String> myRes = wr.getResult();
		
		if(goodRes.size() != myRes.size()){
			Assert.assertEquals(true, false);
		}
		
		int len = myRes.size();
		if(goodRes != null){
			
			for(int i = 0 ; i < len; i++){
				String good = goodRes.get(i);
				String my = myRes.get(i);
				System.out.println("GOOD: " + good);
				System.out.println("MY: " + my);
				Assert.assertTrue(good.equals(my));
			}
			
		}else{
			Assert.assertEquals(true, false);
		}
		
	}
}
