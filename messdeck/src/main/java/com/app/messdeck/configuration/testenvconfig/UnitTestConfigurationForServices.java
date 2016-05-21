package com.app.messdeck.configuration.testenvconfig;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.app.messdeck.configuration.AOPConfiguration;
import com.app.messdeck.configuration.OvalConfiguration;
import com.app.messdeck.configuration.StaticResourceConfiguration;
import com.app.messdeck.repository.CustomerDAO;
import com.app.messdeck.repository.MessDeckServiceDAO;
import com.app.messdeck.repository.VendorDAO;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.app.messdeck.service" })

@EnableTransactionManagement()
@Import({ HibernateConfigurationTestEnvironment.class, StaticResourceConfiguration.class, OvalConfiguration.class,
		AOPConfiguration.class })
@EnableAspectJAutoProxy
public class UnitTestConfigurationForServices extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	@Bean
	public CustomerDAO customerDaoMock() {
		return Mockito.mock(CustomerDAO.class);
	}

	@Bean
	public MessDeckServiceDAO messDeckServiceDAOMock() {
		return Mockito.mock(MessDeckServiceDAO.class);
	}

	@Bean
	public VendorDAO vendorDAOMock() {
		return Mockito.mock(VendorDAO.class);
	}

}
