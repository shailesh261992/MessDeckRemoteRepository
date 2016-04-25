package com.app.messdeck.configuration;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.app.messdeck.controller.CustomerController;
import com.app.messdeck.service.VendorService;

@Configuration
@EnableWebMvc
@EnableTransactionManagement()
@Import({HibernateConfiguration.class,StaticResourceConfiguration.class})
@ComponentScan(basePackages={"com.app.messdeck.controller"},excludeFilters=@ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE,value={CustomerController.class}))
public class UnitTestConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	@Bean
	public VendorService vendorServiceMock() {
		return Mockito.mock(VendorService.class);
	}

}
