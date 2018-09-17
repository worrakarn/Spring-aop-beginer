package com.aop.declarations;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public boolean addMember() {
		System.out.println(getClass()+": DOING MY DB WORK: ADD AN MEMBER");
		return true;
	}
}
