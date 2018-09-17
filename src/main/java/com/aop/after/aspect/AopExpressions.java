package com.aop.after.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	@Pointcut("execution(public * com.aop.after.*.*(..))")
	private void forDaoPackage() {};
	
	@Pointcut("execution(public * com.aop.after.*.get*(..))")
	private void getter() {};
	
	@Pointcut("execution(public * com.aop.after.*.set*(..))")
	private void setter() {};
	
	@Pointcut("forDaoPackage()&&!(getter()||setter())")
	public void forDaoPackageNoGetterSetter() {};
}
