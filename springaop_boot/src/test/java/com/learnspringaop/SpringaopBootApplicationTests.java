package com.learnspringaop;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.learnspringaop.aspect.trace.TracingAspect;
import com.learnspringaop.service.SimpleService;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes=SimpleAspectConfiguration.class)
public class SpringaopBootApplicationTests {
	
	@Autowired
	private TracingAspect tracingaspect;
	
	@Autowired
	private SimpleService simpleService;
	

	@Test
	public void beforeAdviceTest() {
		assertFalse(tracingaspect.isEnteringCalled());
		simpleService.doSomeThingElse(1);
		assertTrue(tracingaspect.isEnteringCalled());
	}
	
	@Test
	public void afterAdviceTest() {
		assertFalse(tracingaspect.isExitCalled());
		simpleService.doSomeThingElse(1);
		assertTrue(tracingaspect.isExitCalled());
	}
	
	//@Test(expected=RuntimeException.class)
	public void afterAdviceTestThrowsException() {
		assertFalse(tracingaspect.isExitCalled());
		simpleService.doSomeThingElse(1);
		assertTrue(tracingaspect.isExitCalled());
	}

}
