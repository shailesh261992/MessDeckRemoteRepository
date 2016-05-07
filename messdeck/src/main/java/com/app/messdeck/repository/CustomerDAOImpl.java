package com.app.messdeck.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.messdeck.businessException.CustomerNotExistsException;
import com.app.messdeck.entity.Customer;
import com.app.messdeck.entity.CustomerAddress;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private HibernateTemplate template;

	@Override
	public Long create(Customer customer) {
		CustomerAddress customerAddress = customer.getCustomerAddress();
		customer.setCustomerAddress(null);
		Long id = (Long) template.save(customer);
		customerAddress.setId(id);
		customer.setCustomerAddress(customerAddress);

		return (Long) template.save(customer);
	}

	@Override
	public void delete(Customer obj) {
		template.delete(obj);

	}

	@Override
	public void update(Customer customer) {
		Customer c = this.get(customer.getId());
		customer.getCustomerAddress().setId(c.getId());
		template.merge(customer);

	}

	@Override
	public Customer get(long id) {
		Customer customer = template.get(Customer.class, id);
		if (customer != null) {
			return customer;
		} else {
			throw new CustomerNotExistsException(id);
		}

	}

	@Override
	public List<Customer> getAll() {

		return template.loadAll(Customer.class);
	}

}
