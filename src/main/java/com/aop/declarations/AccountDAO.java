package com.aop.declarations;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	private String name;
	private String servicerCode;
	
	public void addAccount(Account theAccount, boolean vip) {
		System.out.println(getClass()+": DOING MY DB WORK: ADD AN ACCOUNT");
	}

	public String getName() {
		System.out.println(getClass()+": IN GETNAME");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+": IN SETNAME");
		this.name = name;
	}

	public String getServicerCode() {
		System.out.println(getClass()+": IN GETSERVICE");
		return servicerCode;
	}

	public void setServicerCode(String servicerCode) {
		System.out.println(getClass()+": IN SETSERVICE");
		this.servicerCode = servicerCode;
	}

}
