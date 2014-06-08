package org.tstraszewski.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LogAspect {
	
	@Before("execution(* pl.poznan.put.cs.sdm.*.*(..))")
	public void logBefore(JoinPoint jp){
		
		System.out.println("------\nTyp: " + jp.getKind() + "\nMetoda: " + jp.getSignature().getName() + " [" + jp.getSourceLocation()+ "]\nArgs: " + jp.getArgs());
	}
}
