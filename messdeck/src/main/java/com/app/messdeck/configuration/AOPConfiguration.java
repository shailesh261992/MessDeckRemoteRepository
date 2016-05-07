package com.app.messdeck.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.messdeck.aspects.ValidationAspect;

import sampletest.testoval.Example;


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
