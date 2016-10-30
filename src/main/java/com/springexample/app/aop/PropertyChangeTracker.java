package com.springexample.app.aop;



import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * An aspect that logs a message before any property (javabeans setter method) is invoked
 */
@Aspect
public class PropertyChangeTracker {
    private Logger logger = Logger.getLogger(PropertyChangeTracker.class);

    @Before("execution(void getMessage())")
    public void trackChange() {
        logger.info("property about to change");
        System.out.println("**********************property about to change****************************");
    }
}