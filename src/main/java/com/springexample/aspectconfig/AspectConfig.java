package com.springexample.aspectconfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@EnableAspectJAutoProxy
@ComponentScan(basePackages="com.springexample")
public class AspectConfig {
}
 