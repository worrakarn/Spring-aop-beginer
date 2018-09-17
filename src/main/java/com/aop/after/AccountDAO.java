package com.aop.after;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class AccountDAO {
	private String name;
	private String servicerCode;
	
	public List<Account> findAccount(boolean tripwire){
		List<Account> theAccounts = new ArrayList<>();
		
		Account accountOne = new Account("Orawan");
		Account accountTwo = new Account("Worrakarn");
		
		theAccounts.add(accountOne);
		theAccounts.add(accountTwo);
		
		if (tripwire) {
			throw new RuntimeException("No soup for you!!!");
		}
		System.out.println("Method Run");
		return theAccounts;
	}
	
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
