package com.springexample.app.aop;

import org.aspectj.lang.JoinPoint;

public class LoggingAspect {
	public void log(JoinPoint jp) throws Throwable {
		System.out.println("Before executing " + jp.getSignature().getName()
				+ "()");
	}
}
