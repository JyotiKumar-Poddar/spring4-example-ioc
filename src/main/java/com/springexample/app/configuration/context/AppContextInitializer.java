package com.springexample.app.configuration.context;

import java.util.Date;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.AbstractEnvironment;

import com.springexample.app.bean.FirstInterface;
import com.springexample.app.bean.SecondInterfacae;
import com.springexample.app.configuration.AppConfiguration;
import com.springexample.app.service.HelloWorldService;
import com.springexample.service.StudentService;
import com.springexample.service.UserService;

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
		
		HelloWorldService helloWorldService =  ctx.getBean("helloWorldService",HelloWorldService.class);
		System.out.println(helloWorldService.getMessageService());
	
		// Resolving chicken egg problem.
		FirstInterface first = ctx.getBean("firstImpl", FirstInterface.class);
		first.printMessage();
		SecondInterfacae second = ctx.getBean("secondImpl",
				SecondInterfacae.class);
		second.printMessage();
		ctx.close();
	}
}
