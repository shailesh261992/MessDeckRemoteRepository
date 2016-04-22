package com.websystique.hibernate.model;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.app.messdeck.configuration.MessDeckConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MessDeckConfiguration.class })
@WebAppConfiguration
public class TestStudent {

	@Autowired
	HibernateTemplate template;

	@Test
	@Transactional
	public void test() {
		Student student = new Student("Sam", "Disilva", "Maths");
		Address address = new Address("10 Silver street", "NYC", "USA");
		Serializable id = template.save(student);
		address.setId((long) id);
		student.setAddress(address);
		template.save(student);

	}

}
