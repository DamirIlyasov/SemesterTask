package com.ilyasov.aop;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyLogger {
    private Logger log = Logger.getLogger(getClass());

    @Before("execution(* com.ilyasov.controller.AuthController.*(..))")
    public void before() {
        System.out.println("Authorization in process");
    }

    @After("execution(* com.ilyasov.controller.AuthController.*(..))")
    public void log(JoinPoint point) {
        BasicConfigurator.configure();
        log.info(point.getSignature().getName() + " method started");
    }
}
