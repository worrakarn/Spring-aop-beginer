package com.aop.afterthrow;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.DemoConfig;

public class ThrowingMainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> myAccount = null;
		try {
			myAccount = theAccountDAO.findAccount(true);
		} catch (Exception e) {
			System.out.println("\n\nMain Progarm ... caught exception: "+e);
		}
		if (myAccount!=null) {
			myAccount.forEach(System.out::println);
		}else System.out.println("null");
		
		context.close();

	}

}
