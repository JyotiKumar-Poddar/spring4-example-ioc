package com.springexample.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.stereotype.Component;


//@Component : You can define a bean and remove the @Component annotation from this advice.
@Aspect
public class BeforeLoggingAspect {

	@Before("execution(* com.springexample.service.StudentService.printData())")
	public void doAccessCheck() {
		System.out.println("Done! Loading ........ 100% ");
	}
	// To implement Advice on custom annotation JournalActivity
	//@Before(value = "@annotation(JournalActivity)")  
    @Before("@annotation(JournalActivity)") // more cleaner way to define
	public void getJournalActivity(JoinPoint joinPoint) {

		System.out.println("getJournalActivity " + joinPoint.getSignature());
		// Accessing the value of annotation
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		JournalActivity journalActivityAnnotation = method
				.getAnnotation(JournalActivity.class);
		System.out.println("Value on the annonation "
				+ journalActivityAnnotation + "   \n "
				+ journalActivityAnnotation.value());
	}
}
