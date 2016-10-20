package com.learnspringaop.trace;

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

	public boolean isEnteringCalled() {
		return enteringCalled;
	}

	public void setEnteringCalled(boolean enteringCalled) {
		this.enteringCalled = enteringCalled;
	}
	
	@Before("execution(* *())")
	public void entering(JoinPoint joinPoint){
		enteringCalled = true;
		System.out.println("inside entering");
		logger.trace("Entering : " + joinPoint.getStaticPart().getSignature().toString());
	}
	

}

