/**
 * 
 */
package com.learnspringaop.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author z001qgd
 *
 */
@Service
public class LocalMethodService {

	@Transactional
	public void transactionalMethod(){
		
	}
	
	public void callsTransactionalMethod(){
		transactionalMethod();
	}
}
