package com.aop.befoce;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public void addMember() {
		System.out.println(getClass()+": DOING MY DB WORK: ADD AN MEMBER");
	}
}
