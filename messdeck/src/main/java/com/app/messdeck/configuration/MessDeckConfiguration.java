package com.app.messdeck.configuration;

import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import net.sf.oval.guard.GuardInterceptor;
import net.sf.oval.integration.spring.SpringValidator;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.app.messdeck.repository", "com.app.messdeck.controller",
		"com.app.messdeck.service" })
@EnableTransactionManagement()
@Import({ HibernateConfiguration.class, StaticResourceConfiguration.class })
public class MessDeckConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	@Bean
	@Override
	public Validator getValidator() {
		// return new SpringValidator(new net.sf.oval.Validator());
		return new LocalValidatorFactoryBean();

	}
	

	

	@Bean
	public GuardInterceptor guardInterceptor() {
		return new GuardInterceptor();
	}

	@Bean
	public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
		BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
		beanNameAutoProxyCreator.setProxyTargetClass(true);
		beanNameAutoProxyCreator.setBeanNames("VendorDTO");
		beanNameAutoProxyCreator.setInterceptorNames("guardInterceptor");
		return beanNameAutoProxyCreator;
	}

}
