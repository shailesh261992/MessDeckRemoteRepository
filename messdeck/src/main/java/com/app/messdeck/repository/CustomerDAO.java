package com.app.messdeck.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.messdeck.entity.Customer;

@Repository
@Transactional
public class CustomerDAO {

    @Autowired
	private HibernateTemplate template;

	public void create(Customer obj) {
		template.save(obj);
	}

	public void delete(Customer obj) {
		template.delete(obj);

	}

	public void update(Customer obj) {
		template.update(obj);

	}

	public Customer read(long id) {
		return template.get(Customer.class, id);
	}

}
