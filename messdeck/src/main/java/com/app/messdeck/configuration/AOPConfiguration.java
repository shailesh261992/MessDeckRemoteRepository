package com.app.messdeck.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sampletest.testoval.Example;
import sampletest.testoval.ValidationAspect;

@Configuration
public class AOPConfiguration {
	
	@Bean
	public ValidationAspect validationAspect() {
		return new ValidationAspect();
	}
	
	@Bean
	public Example example(){
		return new Example();
	}

}
