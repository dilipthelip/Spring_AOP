package com.learnspringaop.aspect.trace;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundAdviceAspect {

	
	@Around("execution(* aroundAdvice())")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
		
		String methodInformation = joinPoint.getStaticPart().getSignature().toString();
		System.out.println("Method Information : "+ methodInformation);
		
		try {
			joinPoint.proceed();
			return "From Around Advice";
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
		
	}
}
