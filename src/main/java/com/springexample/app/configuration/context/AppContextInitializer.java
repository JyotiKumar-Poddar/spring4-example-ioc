package com.springexample.app.configuration.context;

import java.util.Date;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.AbstractEnvironment;

import com.springexample.app.bean.FirstInterface;
import com.springexample.app.bean.SecondInterfacae;
import com.springexample.app.configuration.AppConfiguration;
import com.springexample.app.service.helloWorldService;
import com.springexample.service.StudentService;
import com.springexample.service.UserService;

class A{
	Date dob;

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
}


public class AppContextInitializer {

	public static void main(String[] args) {
		// to keep access of bean of same profile else get error bean not found exception
				System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "dev");
	
		/*AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				AppConfiguration.class);*/
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfiguration.class);
		ctx.refresh();

		UserService userService = ctx.getBean(UserService.class);
		userService.multiply(2, 3);

		StudentService studentService = ctx.getBean("studentService",
				StudentService.class);
		studentService.printData();

		System.out.println("Active Profile Name ***"
				+ System.getProperty("spring.profiles.active") + "***");

		System.out.println(ctx);

		helloWorldService helloWorldService = (com.springexample.app.service.helloWorldService) ctx
				.getBean("helloWorldService");
		System.out.println(helloWorldService.getMessageService());
		DateTimeFormatter format = org.joda.time.format.DateTimeFormat
				.forPattern("yyyyMMdd");
		LocalDateTime lDate = org.joda.time.LocalDateTime.parse("20140518",
				format);
		Date dt = lDate.toDate();
		A a = new A();
		a.setDob(dt);
		System.out.println(a.getDob());
		System.out.println(new Date());
		System.out.println(ctx.getBean("firstImpl"));
		// Resolving chicken egg problem.
		FirstInterface first = ctx.getBean("firstImpl", FirstInterface.class);
		SecondInterfacae second = ctx.getBean("secondImpl",
				SecondInterfacae.class);
		first.printMessage();
		second.printMessage();
	   
	}
}
