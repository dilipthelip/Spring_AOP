package com.learnspringaop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.learnspringaop.aspect.trace.DemoClassAspect;
import com.learnspringaop.cglibvsdynamic.DemoClassImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes=SimpleAspectConfiguration.class)
public class DemoClassTest {
	
	@Autowired
	private DemoClassAspect aspect;
	
	@Autowired
	public DemoClassImpl demoClass;
	
	@Test
	public void advice(){
		
		demoClass.adviceMethod1();
	}

}
