package com.aop.declarations.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	@Pointcut("execution(public * com.aop.declarations.*.*(..))")
	public void forDaoPackage() {};
	
	@Pointcut("execution(public * com.aop.declarations.*.get*(..))")
	private void getter() {};
	
	@Pointcut("execution(public * com.aop.declarations.*.set*(..))")
	private void setter() {};
	
	@Pointcut("forDaoPackage()&&!(getter()||setter())")
	public void forDaoPackageNoGetterSetter() {};
}
