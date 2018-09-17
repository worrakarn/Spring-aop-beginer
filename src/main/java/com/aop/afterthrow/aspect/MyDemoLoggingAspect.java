package com.aop.afterthrow.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.aop.afterthrow.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	@AfterThrowing(pointcut="execution(* com.aop.afterthrow.AccountDAO.findAccount(..))",
			throwing="theExe")
	public void afterThrowingFindAccountsAdvice(
			JoinPoint theJoinPoint, Throwable theExe) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("Executing @AfterThrowing Method : "+method);
		
		System.out.println("Exception is : "+theExe);
	}
	
	@AfterReturning(pointcut="execution(* com.aop.afterthrow.AccountDAO.findAccount(..))",
			returning="result")
	public void afterReturningFindAccountAdvice(
			JoinPoint theJoinPoint,List<Account> result) {
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("Executing @AfterReturning Method : "+method);
		
		System.out.println("Result : "+result);
		
		//result.forEach(p->p.setName(p.getName().toUpperCase()));
		convertAccoutNameToUpperCase(result);
		
	}
	
	private void convertAccoutNameToUpperCase(List<Account> result) {
		for (Account tempAccount : result) {
			String theUpperCase = tempAccount.getName().toUpperCase();
			tempAccount.setName(theUpperCase);
		}
		
	}

	@Before("com.aop.afterthrow.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n======= Executing @Before advice on addAccount()");
	}

}
