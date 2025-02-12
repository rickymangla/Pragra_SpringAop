package com.example.practice_SpringAop.aop;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Aspect
@Component 
public class LoggingAdvice {

    public Logger logger = LoggerFactory.getLogger(LoggingAdvice.class);

    @Pointcut(value="execution(* com.example.practice_SpringAop.*.*.*(..))")
    public void pointCutForLogging() {

    }

    @Around("pointCutForLogging()")
    public Object aroundAdviceForLogger(ProceedingJoinPoint pjp) throws Throwable {
        String className = pjp.getTarget().getClass().getName();
        String methodName = pjp.getSignature().getName();
        Object[] args = pjp.getArgs();
        ObjectMapper objectMapper = new ObjectMapper();
        String arguments = objectMapper.writeValueAsString(args);

        logger.info(Instant.now() + "Class " + className + "Method " + methodName  +
                "started execution with parameters " + arguments);

        Object returnData = pjp.proceed();
        String response = objectMapper.writeValueAsString(returnData);

        logger.info(Instant.now() + "Class " + className + "Method " + methodName  +
                "finished execution with result " + response);
        return returnData;
    }
}
