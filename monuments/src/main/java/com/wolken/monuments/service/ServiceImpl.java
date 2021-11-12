package com.wolken.monuments.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.wolken.monuments.controller.HelloController;

@Component
public class ServiceImpl implements Service {
	
	public void printHello() {
		Logger logger=Logger.getLogger(HelloController.class);
		logger.info("Hello service");
	}
}