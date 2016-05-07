package com.app.messdeck.repository;

import java.util.List;

import com.app.messdeck.entity.Customer;

public interface CustomerDAO {

	Long create(Customer obj);

	void delete(Customer obj);

	void update(Customer obj);

	Customer get(long id);
	
	List<Customer> getAll();

}