package com.aop.around;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.DemoConfig;


public class AroundMainDemoApp {
	
	private static Logger myLogger = Logger.getLogger(AroundMainDemoApp.class.getName());

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("\nMain Program : AroundMainApp");
		
		myLogger.info("Calling getFortune");
		
		try {
			String data = theFortuneService.getFortune(false);
			
			myLogger.info("\nMyFortune is : "+data);
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		
		myLogger.info("finished");
		
		context.close();

	}

}
