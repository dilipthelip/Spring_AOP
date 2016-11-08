package com.learnspringaop.cglibvsdynamic;

import org.springframework.stereotype.Component;

@Component
public class DemoClassImpl implements DemoClass  {
	
	public void adviceMethod1(){
		System.out.println("Inside adviceMethod1");
	}

	public void adviceMethod2(){
		System.out.println("Inside adviceMethod2");
	}

}
