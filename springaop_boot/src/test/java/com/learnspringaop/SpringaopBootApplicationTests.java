package com.learnspringaop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.learnspringaop.service.SimpleService;
import com.learnspringaop.trace.TracingAspect;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes=SimpleAspectConfiguration.class)
public class SpringaopBootApplicationTests {
	
	@Autowired
	private TracingAspect tracingaspect;
	
	@Autowired
	private SimpleService simpleService;
	

	@Test
	public void contextLoads() {
		simpleService.doSomeThing();
	}

}
