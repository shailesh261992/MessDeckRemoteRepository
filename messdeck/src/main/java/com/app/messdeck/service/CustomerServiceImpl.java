package com.app.messdeck.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.messdeck.aspects.ValidateWithOval;
import com.app.messdeck.model.dto.CustomerDTO;
import com.app.messdeck.repository.CustomerDAO;
import com.app.messdeck.utility.DTOConverter;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO dao;

	@Override
	public CustomerDTO getCustomerSummary(Long id) {

		// Long id2 = this.createCustomer(createCustomerDTO());
		return DTOConverter.EntityToDTOConverter(dao.get(id));

	}

	@Override
	@ValidateWithOval
	public Long createCustomer(CustomerDTO dto) {
		
		return null;

	}

	@Override
	public void updateCustomer(CustomerDTO dto) {
		dao.update(DTOConverter.DTOToEntityCoverter(dto));
	}

	@Override
	public void deleteCustomer(Long id) {
		dao.delete(dao.get(id));

	}

}
