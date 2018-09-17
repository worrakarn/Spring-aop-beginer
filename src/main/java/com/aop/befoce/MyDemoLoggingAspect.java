package com.aop.befoce;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Pointcut ("execution(public void add*())")
	private void add() {}
	
	@Pointcut ("execution(public void add*(com.aop.befoce.Account, boolean))")
	private void argAndBoolean() {}
	
	@Pointcut ("execution(public void add*(com.aop.befoce.Account, ..))")
	private void argAndAnyParam() {}
	
	@Before("argName()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n======= Executing @Before advice on add()");
	}

}
