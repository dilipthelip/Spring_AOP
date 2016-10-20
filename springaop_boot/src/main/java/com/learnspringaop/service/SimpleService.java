package com.learnspringaop.service;

import org.springframework.stereotype.Service;

@Service
public class SimpleService {
	
	public void doSomeThingElse(int i){
		System.out.println("Inside doSomeThingElse : ");
	}

}
