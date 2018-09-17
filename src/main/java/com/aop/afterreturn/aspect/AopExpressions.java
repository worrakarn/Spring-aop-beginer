package com.aop.afterreturn.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	@Pointcut("execution(public * com.aop.afterreturn.*.*(..))")
	private void forDaoPackage() {};
	
	@Pointcut("execution(public * com.aop.afterreturn.*.get*(..))")
	private void getter() {};
	
	@Pointcut("execution(public * com.aop.afterreturn.*.set*(..))")
	private void setter() {};
	
	@Pointcut("forDaoPackage()&&!(getter()||setter())")
	public void forDaoPackageNoGetterSetter() {};
}
