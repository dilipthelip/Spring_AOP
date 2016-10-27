package com.learnspringaop.aspect.trace;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionLoggingAspect {

	@AfterThrowing(pointcut="com.learnspringaop.architechture.SystemArchitecutre.repositoryCall() || com.learnspringaop.architechture.SystemArchitecutre.serviceCall()",throwing="ex" )
	public void logException(Exception ex){
		System.out.println(" Inside logException Aspect ");
		System.err.println("Exception logged in ExceptionLoggingAspect : " +  ex);
	}
}
