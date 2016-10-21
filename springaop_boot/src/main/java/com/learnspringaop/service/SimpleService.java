package com.learnspringaop.service;

import org.springframework.stereotype.Service;

@Service
public class SimpleService {
	
	public void doSomeThingElse(int i){
		System.out.println("Inside doSomeThingElse : ");
	}
	
	public void throwsRuntimeException(boolean flag) throws RuntimeException{
		
		if(flag){
			throw new RuntimeException();
		}
	}
	
	
		public String afterReturning() throws RuntimeException{
		
			return "Success";
	}

}
