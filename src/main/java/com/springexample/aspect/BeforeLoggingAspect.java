package com.springexample.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
//import org.springframework.stereotype.Component;


//@Component : You can define a bean and remove the @Component annotation from this advice.
@Aspect
public class BeforeLoggingAspect {

	@Before("execution(* com.springexample.service.StudentService.printData())")
	public void doAccessCheck() {
		System.out.println("Done! Loading ........ 100% ");
	}
}
