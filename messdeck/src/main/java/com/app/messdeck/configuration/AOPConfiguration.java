package com.app.messdeck.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.app.messdeck.aspects.MethodLogger;
import com.app.messdeck.aspects.ValidationAspect;

@Configuration
@ComponentScan(basePackages = { "com.app.messdeck.aspects" })
public class AOPConfiguration {

	// @Bean
	// public ValidationAspect validationAspect() {
	// return new ValidationAspect();
	// }
	//
	// @Bean
	// public MethodLogger methodLoggerAspect() {
	// return new MethodLogger();
	// }

	// @Bean
	// public Example example(){
	// return new Example();
	// }

}
