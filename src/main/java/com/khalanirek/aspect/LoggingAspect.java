package com.khalanirek.aspect;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class LoggingAspect {
//////////////////////////////////////// Controller Layer ////////////////////////////////////////
	private static final Logger logger = LogManager.getLogger("HelloWorld");
	@Before("execution(* com.controller.*.add*(..))")
	public void beforeControllerAddAdvice(JoinPoint theJoinPoint) {
		Object[] args = theJoinPoint.getArgs();
		for (Object arg : args) {
			MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
			System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Adding: "  + arg);
		}
	}

	@Before("execution(* com.controller.*.get*(..))")
	public void beforeControllerGetAdvice(JoinPoint theJoinPoint) {
		Object[] args = theJoinPoint.getArgs();
		if (args.length == 0) {
			MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
			System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Getting " + methodSignature.getMethod().getGenericReturnType());
		} else {
			for (Object arg : args) {
				MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
				System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Getting " + methodSignature.getReturnType().getSimpleName() + " with Id: " + arg);
			}
		}
		logger.error("HELLO WORLD!!!");
	}

	@Before("execution(* com.controller.*.update*(..))")
	public void beforeControllerUpdateAdvice(JoinPoint theJoinPoint) {
		Object[] args = theJoinPoint.getArgs();
		for (Object arg : args) {
			MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
			System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Updating: "  + arg);
		}
	}

	@Before("execution(* com.controller.*.delete*(..))")
	public void beforeControllerDeleteAdvice(JoinPoint theJoinPoint) {
		Object[] args = theJoinPoint.getArgs();
		for (Object arg : args) {
			MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
			System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Deleting " + methodSignature.getMethod().getName().substring(6) + " with Id: " + arg);
		}
	}

	@AfterReturning(pointcut="execution(* com.controller.*.add*(..))",
			returning="result")
	public void afterReturningControllerAddAdvice(JoinPoint theJoinPoint, Object result){
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Added: " + result);
	}

	@SuppressWarnings("unchecked")
	@AfterReturning(
		pointcut="execution(* com.controller.*.get*(..))",
		returning="result")
	public void afterReturningControllerGetAdvice(JoinPoint theJoinPoint, Object result) {
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		if (result instanceof Collection) {
			Collection<Object> results = (Collection<Object>) result;
			System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Returned " + methodSignature.getMethod().getGenericReturnType() + ":");
			for (Object res : results) {
				System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Returned: " + res);
			}
		}
		else {
			System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Returned: " + result);
		}
	}

	@AfterReturning(
			pointcut="execution(* com.controller.*.update*(..))",
			returning="result")
	public void afterReturningControllerUpdateAdvice(JoinPoint theJoinPoint, Object result){
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Updated: " + result);
	}

	@AfterReturning(
			pointcut="execution(* com.controller.*.delete*(..))",
			returning="result")
	public void afterReturningControllerDeleteAdvice(JoinPoint theJoinPoint, Object result){
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Deleted " + methodSignature.getMethod().getName().substring(6) + " with Id: " + result);
	}

//////////////////////////////////////// Service Layer ////////////////////////////////////////
	/*@Before("execution(* com.service.*.save*(..))")
	public void beforeServiceSaveAdvice(JoinPoint theJoinPoint) {
		Object[] args = theJoinPoint.getArgs();
		for (Object arg : args) {
			MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
			System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Saving: "  + arg);
		}
	}*/

	@Before("execution(* com.service.*.get*(..))")
	public void beforeServiceGetAdvice(JoinPoint theJoinPoint) {
		Object[] args = theJoinPoint.getArgs();
		if (args.length == 0) {
			MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
			System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Getting " + methodSignature.getMethod().getGenericReturnType());
		} else {
			for (Object arg : args) {
				MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
				System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Getting " + methodSignature.getReturnType().getSimpleName() + " with Id: " + arg);
			}
		}
	}

	@Before("execution(* com.service.*.update*(..))")
	public void beforeServiceUpdateAdvice(JoinPoint theJoinPoint) {
		Object[] args = theJoinPoint.getArgs();
		for (Object arg : args) {
			MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
			System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Updating: "  + arg);
		}
	}

	@Before("execution(* com.service.*.delete*(..))")
	public void beforeServiceDeleteAdvice(JoinPoint theJoinPoint) {
		Object[] args = theJoinPoint.getArgs();
		for (Object arg : args) {
			MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
			System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Deleting " + methodSignature.getMethod().getName().substring(6) + " with Id: " + arg);
		}
	}

	@Around("execution(* com.service.*.save*(..))")
	public Object aroundServiceSaveAdvice(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		// Before
		Object[] args = theProceedingJoinPoint.getArgs();
		for (Object arg : args) {
			MethodSignature methodSignature = (MethodSignature) theProceedingJoinPoint.getSignature();
			System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Saving: "  + arg);
		}

		Object result = theProceedingJoinPoint.proceed();
		// After
		MethodSignature methodSignature = (MethodSignature) theProceedingJoinPoint.getSignature();
		System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Saved: " + result);
		return result;
	}
	/*
	@AfterReturning(pointcut="execution(* com.service.*.save*(..))",
			returning="result")
	public void afterReturningServiceSaveAdvice(JoinPoint theJoinPoint, Object result){
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Saved: " + result);
	}
*/
	@SuppressWarnings("unchecked")
	@AfterReturning(
		pointcut="execution(* com.service.*.get*(..))",
		returning="result")
	public void afterReturningServiceGetAdvice(JoinPoint theJoinPoint, Object result) {
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		if (result instanceof Collection) {
			Collection<Object> results = (Collection<Object>) result;
			System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Returned " + methodSignature.getMethod().getGenericReturnType() + ":");
			for (Object res : results) {
				System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Returned: " + res);
			}
		}
		else {
			System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Returned: " + result);
		}
	}

	@AfterReturning(
			pointcut="execution(* com.service.*.update*(..))",
			returning="result")
	public void afterReturningServiceUpdateAdvice(JoinPoint theJoinPoint, Object result){
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Updated: " + result);
	}

	@AfterReturning(
			pointcut="execution(* com.service.*.delete*(..))",
			returning="result")
	public void afterReturningServiceDeleteAdvice(JoinPoint theJoinPoint, Object result){
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Deleted " + methodSignature.getMethod().getName().substring(6) + " with Id: " + result);
	}

//////////////////////////////////////// Repository Layer ////////////////////////////////////////
	/*@Before("execution(* com.repository.*.save*(..))")
	public void beforeRepositorySaveAdvice(JoinPoint theJoinPoint) {
		Object[] args = theJoinPoint.getArgs();
		for (Object arg : args) {
			MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
			System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Saving: "  + arg);
		}
	}*/

	@Before("execution(* com.repository.*.get*(..))")
	public void beforeRepositoryGetAdvice(JoinPoint theJoinPoint) {
		Object[] args = theJoinPoint.getArgs();
		if (args.length == 0) {
			MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
			System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Getting " + methodSignature.getMethod().getGenericReturnType());
		} else {
			for (Object arg : args) {
				MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
				System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Getting " + methodSignature.getReturnType().getSimpleName() + " with Id: " + arg);
			}
		}
	}

	@Before("execution(* com.repository.*.delete*(..))")
	public void beforeRepositoryDeleteAdvice(JoinPoint theJoinPoint) {
		Object[] args = theJoinPoint.getArgs();
		for (Object arg : args) {
			MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
			System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Deleting " + methodSignature.getMethod().getName().substring(6) + " with Id: " + arg);
		}
	}

	@Around("execution(* com.repository.*.save*(..))")
	public Object aroundRepositorySaveAdvice(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		// Before
		Object[] args = theProceedingJoinPoint.getArgs();
		for (Object arg : args) {
			MethodSignature methodSignature = (MethodSignature) theProceedingJoinPoint.getSignature();
			System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Saving: "  + arg);
		}

		Object result = theProceedingJoinPoint.proceed();
		// After
		MethodSignature methodSignature = (MethodSignature) theProceedingJoinPoint.getSignature();
		System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Saved " + methodSignature.getMethod().getName().substring(4) + " with Id: " + result);

		return result;
	}
	/*@AfterReturning(pointcut="execution(* com.repository.*.save*(..))",
			returning="result")
	public void afterReturningRepositorySaveAdvice(JoinPoint theJoinPoint, Object result){
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Saved " + methodSignature.getMethod().getName().substring(4) + " with Id: " + result);
	}*/

	@SuppressWarnings("unchecked")
	@AfterReturning(
		pointcut="execution(* com.repository.*.get*(..))",
		returning="result")
	public void afterReturningRepositoryGetAdvice(JoinPoint theJoinPoint, Object result) {
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		if (result instanceof Collection) {
			Collection<Object> results = (Collection<Object>) result;
			System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Returned " + methodSignature.getMethod().getGenericReturnType() + ":");
			for (Object res : results) {
				System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Returned: " + res);
			}
		}
		else {
			System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Returned: " + result);
		}
	}

	@AfterReturning(
			pointcut="execution(* com.repository.*.delete*(..))",
			returning="result")
	public void afterReturningRepositoryDeleteAdvice(JoinPoint theJoinPoint, Object result){
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println(methodSignature.getDeclaringType().getSimpleName() + ": Deleted " + methodSignature.getMethod().getName().substring(6) + " with Id: " + result);
	}
}
