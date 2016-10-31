package com.learnspringaop.architechture;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class SystemArchitecutre {
	
	//@Pointcut("execution(* (@org.springframework.stereotype.Repository *).*(..))")
	@Pointcut("execution(* com.learnspringaop..repository.*.*(..))")
	public void repositoryCall(){
		
	}
	
	//@Pointcut("execution(* (@org.springframework.stereotype.Service *).*(..))")
	@Pointcut("execution(* com.learnspringaop..service.*.*(..))")
	public void serviceCall(){
		
	}
}
