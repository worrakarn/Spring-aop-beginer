package com.aop.declarations.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.aop.declarations.Account;

@Aspect
@Component
@Order(2)
public class MyApiAspect {
	@Before("com.aop.declarations.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void performAPI(JoinPoint theJoinPoint) {
		System.out.println("\n======= Perform API");
		
		//display the method signature
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method : "+methodSignature);
		
		//display the method arguments
		Object[] args = theJoinPoint.getArgs();
		
		for (Object tempArg : args) {
			System.out.println(tempArg);
			
			if (tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				System.out.println("Accout Name : "+theAccount.getName());
			}
		}
	}
}
