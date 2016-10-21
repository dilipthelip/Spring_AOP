package com.learnspringaop.aspect.trace;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterThrowingAspect {
	
	boolean afterThrowing;

	public boolean isAfterThrowing() {
		return afterThrowing;
	}

	public void setAfterThrowing(boolean afterThrowing) {
		this.afterThrowing = afterThrowing;
	}

	//@Before("execution(* doSomeThingElse(..))")
	@AfterThrowing(pointcut="execution(* throwsRuntimeException(..))",throwing="ex" )
	public void afterThrowingAspect(RuntimeException ex){
		afterThrowing=true;
		System.out.println("Inside afterThrowingAspect : ");
		System.err.println("The Exception is : "+ ex);
	}
	
}
