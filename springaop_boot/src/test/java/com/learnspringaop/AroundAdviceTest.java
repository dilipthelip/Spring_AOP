package com.learnspringaop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.learnspringaop.aspect.trace.AroundAdviceAspect;
import com.learnspringaop.service.SimpleService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes=SimpleAspectConfiguration.class)
public class AroundAdviceTest {
	
	@Autowired
	private AroundAdviceAspect aroundAdvice;
	
	@Autowired
	private SimpleService simpleService;
	
	@Test
	public void aroundAdvice(){
		
		String returnVal = simpleService.aroundAdvice();
		System.out.println("returnVal is : "+ returnVal);
	}

}
