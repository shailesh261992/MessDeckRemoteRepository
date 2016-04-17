package com.app.messdeck.configuration;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.app.messdeck.model.Address;
import com.app.messdeck.model.Customer;
import com.app.messdeck.model.EmailID;
import com.app.messdeck.model.Item;
import com.app.messdeck.model.MessDeckService;
import com.app.messdeck.model.Name;
import com.app.messdeck.model.Owner;
import com.app.messdeck.model.Person;
import com.app.messdeck.model.Vendor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.app.messdeck.repository", "com.app.messdeck.controller",
		"com.app.messdeck.service" })
@EnableTransactionManagement
public class MessDeckConfiguration {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		// viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		basicDataSource.setUrl("jdbc:mysql://localhost:3306/messdeck");
		basicDataSource.setUsername("root");
		basicDataSource.setPassword("Welcome@1");
		basicDataSource.setInitialSize(2);
		basicDataSource.setMaxActive(5);

		return basicDataSource;

	}

	@Bean
	public SessionFactory sessionFactory() {

		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource());
		localSessionFactoryBean.setAnnotatedClasses(Person.class, Customer.class, Address.class, Name.class,
				EmailID.class, Owner.class, Vendor.class, Item.class, MessDeckService.class);

		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create");
		hibernateProperties.setProperty("hibernate.show_sql", "true");

		localSessionFactoryBean.setHibernateProperties(hibernateProperties);

		return localSessionFactoryBean.getObject();
	}

	@Bean
	public HibernateTransactionManager txManager() {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory());
		return hibernateTransactionManager;
	}

	@Bean
	public HibernateTemplate template() {
		HibernateTemplate hibernateTemplate = new HibernateTemplate();
		hibernateTemplate.setSessionFactory(sessionFactory());
		return hibernateTemplate;
	}

}
