package com.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.MDC;

@Aspect
public class ServiceAspect {

  @Pointcut("execution(* com.demo.service.*.*(..))")
  public void serviceLayer() {}

  /**
   * @param joinPoint
   */
  @Before("serviceLayer()")
  public void serviceBefore(JoinPoint joinPoint) {
    String className =
        joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName();

    CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
    for (int i = 0; i < codeSignature.getParameterNames().length; i++) {
      MDC.put(codeSignature.getParameterNames()[i], joinPoint.getArgs()[i].toString());
    }

    MDC.put("classname", className);
  }
}
