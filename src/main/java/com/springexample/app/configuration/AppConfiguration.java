package com.springexample.app.configuration;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import com.springexample.app.bean.HelloWorld;
import com.springexample.app.bean.impl.FirstImpl;
import com.springexample.app.bean.impl.HelloWorldImpl;
import com.springexample.app.bean.impl.MessageBean;
import com.springexample.app.bean.impl.SecondImpl;
import com.springexample.app.service.helloWorldService;
import com.springexample.app.service.impl.HelloWorldServiceImpl;
import com.springexample.aspect.BeforeLoggingAspect;
import com.springexample.aspectconfig.AspectConfig;
import com.springexample.service.StudentService;


@Profile("dev")
@Configuration // is used to define bean configuration similar to application context xml.
//@ComponentScan(basePackages="com.springexample.app") // for using Autowired similar as used in xml.
@Import(AspectConfig.class)
@PropertySource("classpath:app.properties")

public class AppConfiguration {
	
	@Inject Environment env;
	
	@Bean(name = "helloWorldBean" ,initMethod = "setup", destroyMethod = "cleanup")
	@Scope("prototype")
	//	or @Scope(BeanDefinition.SCOPE_PROTOTYPE)
	@Qualifier("BeanNameAsID")
	@Description("This is bean description of helloWorldBean")
	public HelloWorld helloWorld() {
		System.out.println(env.getProperty("test"));
		return new HelloWorldImpl(2016,"Year:");
	}
	
	@Bean(name="helloWorldService")
	@Description("This is hello bean service")
	public helloWorldService helloWorldService(){
		return new HelloWorldServiceImpl();
	}
	
	
	@Bean(name="message-bean")
	public MessageBean messageBean(){
		return new MessageBean();
	}
	
	//Solution of chicken egg problem by using setter injection
	// This problem comes when we use setter injection.

	@Bean(name="firstImpl")
	@Primary
	@Qualifier("secondImpl")
	public FirstImpl firstImpl() {
		SecondImpl sl = new SecondImpl();
		FirstImpl fs = new FirstImpl();
		fs.setImpl(sl);
		return fs;
	}
	
	@Bean(name="secondImpl")
	public SecondImpl secondImpl() {
		FirstImpl fs = new FirstImpl();
		SecondImpl sl = new SecondImpl();
		sl.setFirstImpl(fs);
		return sl;
	}
	
	@Bean(name="studentService")
	public StudentService studentService(){
		return new StudentService();
	}
	
	// Defining AOP as a bean
	@Bean
	public BeforeLoggingAspect beforeLoggingAspect(){
		return new BeforeLoggingAspect();
	}
	
}

