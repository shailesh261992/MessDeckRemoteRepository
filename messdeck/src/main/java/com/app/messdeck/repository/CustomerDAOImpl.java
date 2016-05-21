package com.app.messdeck.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.messdeck.businessException.CustomerNotExistsException;
import com.app.messdeck.entity.Customer;
import com.app.messdeck.entity.CustomerAddress;
import com.app.messdeck.entity.Vendor;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private HibernateTemplate template;

	@Autowired
	private VendorDAO vendorDao;

	@Override
	public Long create(Customer customer) {
		Vendor vendor = vendorDao.get(customer.getVendor().getId());
		customer.setVendor(vendor);

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
		Vendor vendor = vendorDao.get(customer.getVendor().getId());
		customer.setVendor(vendor);

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
