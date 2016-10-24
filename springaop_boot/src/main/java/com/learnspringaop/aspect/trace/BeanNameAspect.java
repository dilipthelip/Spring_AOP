package com.learnspringaop.aspect.trace;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BeanNameAspect {

	@Around("bean(*Service)")
	public Object beanNameAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
		
		String methodInformation = joinPoint.getStaticPart().getSignature().toString();
		System.out.println("Method Information in beanNameAdvice : "+ methodInformation);
		
		try {
			return "From beanNameAdvice";
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
		
	}
}
