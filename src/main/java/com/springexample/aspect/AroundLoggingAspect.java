package com.springexample.aspect;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Component
@Aspect
public class AroundLoggingAspect {
	@Around("execution(* com.springexample.service.*.*(..))")
	public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("@Around: Before calculation-"+ new Date());
		joinPoint.proceed();
		System.out.println("@Around: After calculation-"+ new Date());
	}
	
	
	@Before("getMessageMethodPointcut()") // This point @Before advice is called from the Pointcut
	public void loggingBeforeAdvice(){
		System.out.println("Executing loggingAdvice on public String getMessage()");
	}
	
	@Pointcut("execution(public String getMessage())") // Pointcut on method signature public String getMessage() of HelloWorldServiceImpl.java
	public void getMessageMethodPointcut(){
		
	}// getMessageMethodPointcut

	@Before("beforeMethodsPointcut()")
	public void beforeMethodAdvice(){
		System.out.println("Before executing a method in package com.springexample.service.");
	}
	
	@Pointcut("within(com.springexample.service.*)") // Another way of using pointcut
	public void beforeMethodsPointcut() {
	}
}