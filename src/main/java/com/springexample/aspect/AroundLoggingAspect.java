package com.springexample.aspect;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
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

}