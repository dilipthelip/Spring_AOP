package com.learnspringaop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.learnspringaop.service.SimpleService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes=SimpleAspectConfiguration.class)
public class BeanNameAspectTest {

	@Autowired
	private SimpleService simpleService;
	
	@Test
	public void beanNameAdvice(){
		
		String returnVal;
		returnVal = simpleService.beanNameAdvice();
		System.out.println("returnVal : "+ returnVal);
	}
}
