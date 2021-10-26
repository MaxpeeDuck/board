package com.ziumks.board.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("execution(* com.ziumks.board..controller.*Controller.*(..)) " +
            "or execution(* com.ziumks.board..service.*Impl.*(..)) " +
            "or execution(* com.ziumks.board..mapper.*Mapper.*(..))")
    public Object printLog(ProceedingJoinPoint joinPoint) throws Throwable {

        String type = "";
        String name = joinPoint.getSignature().getDeclaringTypeName();

        if(name.contains("Controller") == true) {
            type = "Controller ===> ";
        } else if(name.contains("Service") == true) {
            type = "Service ===> ";
        } else if(name.contains("Mapper") == true) {
            type = "Mappter ===> ";
        }

        logger.debug(type + name + "." + joinPoint.getSignature().getName() + "()");
        return joinPoint.proceed();
    }
}
