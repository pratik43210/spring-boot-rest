package com.pratik.springbootrest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	
	//return-type, class-name.mehtod-name(args)
	@Before("execution(* com.pratik.springbootrest.service.JobService.getAllJobs(..)) || execution(* com.pratik.springbootrest.service.JobService.getJob(..))")
	public void logMethodCall(JoinPoint jp) {
		LOGGER.info("Method called - "+jp.getSignature().getName());
	}
	
	//acts like finally
	@After("execution(* com.pratik.springbootrest.service.JobService.getAllJobs(..)) || execution(* com.pratik.springbootrest.service.JobService.getJob(..))")
	public void logMethodExecuted(JoinPoint jp) {
		LOGGER.info("Method executed - "+jp.getSignature().getName());
	}
	
	//only when there's a exception
	@AfterThrowing("execution(* com.pratik.springbootrest.service.JobService.getAllJobs(..)) || execution(* com.pratik.springbootrest.service.JobService.getJob(..))")
	public void logMethodCrash(JoinPoint jp) {
		LOGGER.info("Method has some issues - "+jp.getSignature().getName());
	}
	
	//only when there's no exception
	@AfterReturning("execution(* com.pratik.springbootrest.service.JobService.getAllJobs(..)) || execution(* com.pratik.springbootrest.service.JobService.getJob(..))")
	public void logMethodExecutionSuccess(JoinPoint jp) {
		LOGGER.info("Method executed successfully - "+jp.getSignature().getName());
	}
}
