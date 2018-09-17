package com.aop.afterthrow.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	@Pointcut("execution(public * com.aop.afterthrow.*.*(..))")
	private void forDaoPackage() {};
	
	@Pointcut("execution(public * com.aop.afterthrow.*.get*(..))")
	private void getter() {};
	
	@Pointcut("execution(public * com.aop.afterthrow.*.set*(..))")
	private void setter() {};
	
	@Pointcut("forDaoPackage()&&!(getter()||setter())")
	public void forDaoPackageNoGetterSetter() {};
}
