package com.learnspringaop;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.learnspringaop.aspect.trace.AfterThrowingAspect;
import com.learnspringaop.aspect.trace.AfterReturningAspect;
import com.learnspringaop.aspect.trace.TracingAspect;
import com.learnspringaop.service.SimpleService;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes=SimpleAspectConfiguration.class)
public class SpringaopBootApplicationTests {
	
	@Autowired
	private TracingAspect tracingaspect;
	
	@Autowired
	private AfterThrowingAspect afterThrowingaspect;
	
	@Autowired
	private	AfterReturningAspect afterReturningAspect;
	
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
	
	@Test
	public void afterReturning() {
		assertFalse(afterReturningAspect.isAfterReturning());
		try {
			simpleService.afterReturning();
			assertTrue(afterReturningAspect.isAfterReturning());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	@Test
	public void afterThrowing() {
		assertFalse(afterThrowingaspect.isAfterThrowing());
		try {
			simpleService.throwsRuntimeException(true);
		} catch (Exception e) {
			// TODO: handle exception
			assertTrue(afterThrowingaspect.isAfterThrowing());
		}
		
		
	}
	
	
}
