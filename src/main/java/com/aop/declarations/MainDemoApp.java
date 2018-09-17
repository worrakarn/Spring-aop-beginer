package com.aop.declarations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.DemoConfig;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
		
		Account theAccount = new Account();
		theAccount.setName("Boss");
		theAccountDAO.addAccount(theAccount,true);
		
		theAccountDAO.setName("foobar");
		theAccountDAO.setServicerCode("silver");
		
		String name = theAccountDAO.getName();
		String service = theAccountDAO.getServicerCode();
		
		System.out.println("Name:"+name);
		System.out.println("Service"+service);
		
		theMembershipDAO.addMember();
		
		context.close();

	}

}
