package com.app.messdeck.s2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.app.messdeck.configuration.MessDeckConfiguration;

@SpringBootApplication
@Import(MessDeckConfiguration.class)
@EnableJpaRepositories
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		// System.out.println("Let's inspect the beans provided by Spring
		// Boot:");
		//
		// String[] beanNames = ctx.getBeanDefinitionNames();
		// Arrays.sort(beanNames);
		// for (String beanName : beanNames) {
		// System.out.println(beanName);
		// }
	}

}
