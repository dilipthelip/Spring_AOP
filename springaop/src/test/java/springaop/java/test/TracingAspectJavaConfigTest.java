package springaop.java.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.learnspringaop.configuration.SimpleAspectConfiguration;
import com.learnspringaop.service.SimpleService;
import com.learnspringaop.trace.TracingAspect;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SimpleAspectConfiguration.class)
public class TracingAspectJavaConfigTest {
	
	@Autowired
	private TracingAspect tracingaspect;
	
	@Autowired
	private SimpleService simpleService;
	

	@Test()
	public void aspectIsCalled(){
		assertFalse(tracingaspect.isEnteringCalled());
		simpleService.doSomeThing();
		assertTrue(tracingaspect.isEnteringCalled());
	}

}
