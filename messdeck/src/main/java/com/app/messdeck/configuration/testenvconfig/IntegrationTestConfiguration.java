package com.app.messdeck.configuration.testenvconfig;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.app.messdeck.configuration.AOPConfiguration;
import com.app.messdeck.configuration.OvalConfiguration;
import com.app.messdeck.configuration.StaticResourceConfiguration;
import com.app.messdeck.test.data.IntegrationTestData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.app.messdeck.repository", "com.app.messdeck.controller",
		"com.app.messdeck.service" })
@EnableTransactionManagement()
@Import({ HibernateConfigurationTestEnvironment.class, StaticResourceConfiguration.class, OvalConfiguration.class,
		AOPConfiguration.class })
@EnableAspectJAutoProxy
public class IntegrationTestConfiguration {

	@Autowired
	HibernateConfigurationTestEnvironment hbconfig;

	@Bean

	public IntegrationTestData getIntegrationTestData() throws IOException {
		IntegrationTestData testData = new IntegrationTestData(hbconfig.template());
		// testData.initializeTestData();
		return testData;

	}

}
