package com.aop.befoce;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.DemoConfig;


public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
		
		Account account = new Account();
		
		theAccountDAO.addAccount(account,true);
		
		theMembershipDAO.addMember();
		
		context.close();

	}

}
