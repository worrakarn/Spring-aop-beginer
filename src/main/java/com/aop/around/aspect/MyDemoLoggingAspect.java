package com.aop.around.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.aop.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
		
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("Executing @Around Method : "+method);
		
		long begin = System.currentTimeMillis();
		
		Object result = null;
		
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			myLogger.warning(e.getMessage());
			
			//Handling Exception
			//result = "Major accident Highway is closed!";
			
			//rethrow exception
			throw e;
		}
		
		long end = System.currentTimeMillis();
		
		myLogger.info("\n==========> Daration = "+ (end-begin)/1000 +"seconds");
		
		return result;
	}

}
