package com.learnspringaop.architechture;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class SystemArchitecutre {
	
	@Pointcut("execution(* (@org.springframework.stereotype.Repository *).*(..))")
	public void repositoryCall(){
		
	}
	
	@Pointcut("execution(* (@org.springframework.stereotype.Service *).*(..))")
	public void serviceCall(){
		
	}
}
