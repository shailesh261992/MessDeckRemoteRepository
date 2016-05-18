package com.app.messdeck.service;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.messdeck.annotations.Loggable;
import com.app.messdeck.aspects.ValidateWithOval;
import com.app.messdeck.entity.Customer;
import com.app.messdeck.model.dto.CustomerDTO;
import com.app.messdeck.repository.CustomerDAO;
import com.app.messdeck.utility.DTOConverter;
import com.app.messdeck.utility.EntityConverter;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	private static Logger logger = Logger.getLogger(CustomerServiceImpl.class);

	@Autowired
	private CustomerDAO dao;

	@Override
	@Loggable
	public CustomerDTO getCustomerSummary(Long id) {

		return EntityConverter.getCustomorSummaryDTO(dao.get(id));

	}

	@Override
	@ValidateWithOval
	public Long createCustomer(CustomerDTO dto) {
		Customer customer = DTOConverter.getCustomer(dto);
		logger.info("dto = " + dto);
		logger.info("customer = " + customer);
		Long id = dao.create(customer);
		return id;

	}

	@Override
	@ValidateWithOval
	public void updateCustomer(CustomerDTO dto) {
		dao.update(DTOConverter.getCustomer(dto));
	}

	@Override
	public void deleteCustomer(Long id) {
		dao.delete(dao.get(id));

	}

}
