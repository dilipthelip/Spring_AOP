package com.learnspringaop;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.learnspringaop.aspect.trace.ExceptionLoggingAspect;
import com.learnspringaop.service.ArchitecutreService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes=SimpleAspectConfiguration.class)
public class ArchitectureServiceTest {
	
	@Autowired
	private ArchitecutreService architecutreService;
	
	@Autowired
	private ExceptionLoggingAspect exceptionAspect;
	
	@Test
	public void throwEx(){
		try {
			assertFalse(architecutreService.isCalled());
			architecutreService.throwEx(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertTrue(architecutreService.isCalled());
			//e.printStackTrace();
		}
	}

}
