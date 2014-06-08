package org.tstraszewski.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import pl.poznan.put.cs.sdm.Customer;
import pl.poznan.put.cs.sdm.CustomerBlackList;

@Aspect
public class IsBannedAspect {

	CustomerBlackList cbl = new CustomerBlackList();
	
	@Around("execution(* pl.poznan.put.cs.sdm.Customer.addRental(..))")
	public void checkIfBanned(JoinPoint jp,ProceedingJoinPoint pjp) throws Exception{
		
		Customer c = (Customer)jp.getTarget();
		boolean banned = cbl.isCustomerBanned(c);
//		System.out.println("\t\t\t" + c + " banned: " + banned);
		if(!banned){
			try {
				pjp.proceed();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
