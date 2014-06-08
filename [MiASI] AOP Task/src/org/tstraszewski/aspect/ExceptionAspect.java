package org.tstraszewski.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ExceptionAspect {

	@AfterThrowing("execution(* pl.poznan.put.cs.sdm*.*())")
	public void catchException(JoinPoint jp){
		
		System.out.println("----\nWyj�tek: " + jp.getSourceLocation());
	}
}
