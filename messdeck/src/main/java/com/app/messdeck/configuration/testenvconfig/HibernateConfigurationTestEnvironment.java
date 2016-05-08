package com.app.messdeck.configuration.testenvconfig;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

@Configuration
@PropertySource("classpath:db.properties")
public class HibernateConfigurationTestEnvironment {
	@Autowired
	private Environment env;

	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(env.getProperty("test.db.driverClassName"));
		basicDataSource.setUrl(env.getProperty("test.db.url"));
		basicDataSource.setUsername(env.getProperty("test.db.userName"));
		basicDataSource.setPassword(env.getProperty("test.db.password"));
		basicDataSource.setInitialSize(2);
		basicDataSource.setMaxActive(25);
		return basicDataSource;

	}

	@Bean
	public SessionFactory sessionFactory() throws IOException {

		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource());
		localSessionFactoryBean.setPackagesToScan(new String[] { "com.app.messdeck.entity" });
		localSessionFactoryBean.setHibernateProperties(hibernateProperties());
		localSessionFactoryBean.afterPropertiesSet();
		return localSessionFactoryBean.getObject();
	}

	@Bean
	public HibernateTransactionManager txManager() throws IOException {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory());

		return hibernateTransactionManager;
	}

	@Bean
	public HibernateTemplate template() throws IOException {
		HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory());
		return hibernateTemplate;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	private Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", env.getProperty("test.hibernate.dialect"));
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("test.hibernate.hbm2ddl.auto"));
		hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("test.hibernate.show_sql"));
		hibernateProperties.setProperty("hibernate.format_sql", env.getProperty("test.hibernate.format_sql"));
		return hibernateProperties;
	}

}
