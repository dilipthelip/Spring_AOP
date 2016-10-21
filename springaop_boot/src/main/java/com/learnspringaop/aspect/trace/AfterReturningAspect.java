package com.learnspringaop.aspect.trace;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterReturningAspect {
	
	boolean afterReturning;
	
	
	public boolean isAfterReturning() {
		return afterReturning;
	}


	public void setAfterReturning(boolean afterReturning) {
		this.afterReturning = afterReturning;
	}

	/**
	 * The argument variable and the returning value inside @AfterReturning annotation should match.
	 * @param str
	 */
	@AfterReturning(pointcut="execution(* afterReturning())",returning="str" )
	public void afterThrowingAspect(String str){
		afterReturning=true;
		System.out.println("Returning String is : "+ str);
	}

}
