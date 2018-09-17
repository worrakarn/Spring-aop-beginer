package com.aop.befoce;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass()+": DOING MY DB WORK: ADD AN ACCOUNT");
	}

}
