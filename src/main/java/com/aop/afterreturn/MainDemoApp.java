package com.aop.afterreturn;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.DemoConfig;


public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> myAccount = theAccountDAO.findAccount();
		myAccount.forEach(System.out::println);
		
		context.close();

	}

}
