package com.app.messdeck.repository;

import com.app.messdeck.entity.Customer;

public interface CustomerDAO {

	Long create(Customer obj);

	void delete(Customer obj);

	void update(Customer obj);

	Customer read(long id);

}