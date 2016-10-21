package com.learnspringaop.aspect.trace;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;

@Component
@Aspect
public class TracingAspect {
	
	Logger logger= LoggerFactory.getLogger(TracingAspect.class);
	
	boolean enteringCalled  = false;
	
	boolean exitCalled = false;

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public boolean isExitCalled() {
		return exitCalled;
	}

	public void setExitCalled(boolean exitCalled) {
		this.exitCalled = exitCalled;
	}

	public boolean isEnteringCalled() {
		return enteringCalled;
	}

	public void setEnteringCalled(boolean enteringCalled) {
		this.enteringCalled = enteringCalled;
	}
	
	@Before("execution(* doSomeThingElse(..))")
	public void entering(JoinPoint joinPoint){
		enteringCalled = true;
		System.out.println("inside entering");
		logger.trace("Entering : " + joinPoint.getStaticPart().getSignature().toString());
	}
	
	@After("execution(* doSomeThingElse(..))")
	public void exiting(JoinPoint joinPoint){
		exitCalled = true;
		System.out.println("inside Exiting");
		logger.trace("Exiting : " + joinPoint.getStaticPart().getSignature().toString());
		
		for(Object obj : joinPoint.getArgs()){
			
			System.out.println("Arguments are : " + obj.toString());
		}
	}
	
	
	

}

