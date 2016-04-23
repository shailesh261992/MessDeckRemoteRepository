package com.app.messdeck.service;

import com.app.messdeck.model.dto.CustomerDTO;

public interface CustomerService {

	CustomerDTO getCustomer(Long id);

	Long createCustomer(CustomerDTO dto);

	void updateCustomer(CustomerDTO dto);

	void deleteCustomer(Long id);

}