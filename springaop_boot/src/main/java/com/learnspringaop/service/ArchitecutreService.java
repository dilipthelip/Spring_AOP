package com.learnspringaop.service;

import org.springframework.stereotype.Service;

@Service
public class ArchitecutreService {
	
	private boolean isCalled;

	public boolean isCalled() {
		return isCalled;
	}

	public void setCalled(boolean isCalled) {
		this.isCalled = isCalled;
	}

	public void throwEx(boolean flag)  throws Exception{
		isCalled= true;
		System.out.println("Inside ThrowEx of ArchitecutreService class");
		if(flag)
			throw new Exception("Exception from Architecture Service");
	}
	
}
