package com.springexample.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;

public class LogginAspectAnnotationDriven {
	@Before("execution(public * *(..))")
	public void beforeAdvice(JoinPoint jp) {
		System.out.println("Annotation driven:Before executing "
				+ jp.getSignature().getName() + "()");
	}
}
