package com.aop.around;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	
	public String getFortune() {
		try {
			//simulate a delay
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Test run");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Expect heavy traffic this moring";
	}

	public String getFortune(boolean b) {
		if(b) throw new RuntimeException("Major accident Highway is closed!");
		
		return getFortune();
	}

}
