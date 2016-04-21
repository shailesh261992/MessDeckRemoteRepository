package com.app.messdeck.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.messdeck.entity.Customer;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private HibernateTemplate template;

	@Override
	public Long create(Customer obj) {
		return (Long) template.save(obj);
	}

	@Override
	public void delete(Customer obj) {
		template.delete(obj);

	}

	@Override
	public void update(Customer obj) {
		template.update(obj);

	}

	@Override
	public Customer read(long id) {
		return template.get(Customer.class, id);
	}

}
