package sampletest.testoval;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ValidationAspect {
	
	
	@Before("validationPointcut()")
	public void validationAdvice(JoinPoint jp){
		 System.out.println("*** additional concern");  
	}
	

	@Pointcut("within(sampletest.testoval.*)")
	public void validationPointcut(){
		
	}
	
	

}
