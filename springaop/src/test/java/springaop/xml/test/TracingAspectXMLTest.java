package springaop.xml.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.learnspringaop.service.SimpleService;
import com.learnspringaop.trace.TracingAspect;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(c"/aopconfig.xml")
@ContextConfiguration(locations="classpath:/aopconfig.xml")
public class TracingAspectXMLTest {
	
	@Autowired
	private TracingAspect tracingaspect;
	
	@Autowired
	private SimpleService simpleService;
	

	@Test()
	public void aspectIsCalled(){
		
		simpleService.doSomeThing();
		
	}
}
