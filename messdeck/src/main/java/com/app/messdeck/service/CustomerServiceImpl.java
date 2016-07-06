package com.app.messdeck.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.messdeck.annotations.Loggable;
import com.app.messdeck.aspects.ValidateWithOval;
import com.app.messdeck.businessException.CustomerNotExistsException;
import com.app.messdeck.businessException.VendorNotExistException;
import com.app.messdeck.entity.Customer;
import com.app.messdeck.entity.Vendor;
import com.app.messdeck.model.dto.CustomerDTO;
import com.app.messdeck.modelmapper.DTOConverter;
import com.app.messdeck.modelmapper.EntityConverter;
import com.app.messdeck.repository.CustomerDAO;
import com.app.messdeck.repository.CustomerRepository;
import com.app.messdeck.repository.VendorRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	private static Logger logger = Logger.getLogger(CustomerServiceImpl.class);

	@Autowired
	private CustomerRepository repository;

	@Autowired
	private VendorRepository vendorRepository;

	@Override
	@Loggable
	public CustomerDTO getCustomerSummary(Long id) {

		Optional<Customer> customer = Optional.ofNullable(repository.findOne(id));
		if (customer.isPresent()) {
			return EntityConverter.getCustomorSummaryDTO(customer.get());
		} else {
			throw new CustomerNotExistsException(id);
		}

	}

	@Override
	@ValidateWithOval
	public Long createCustomer(CustomerDTO dto) {

		if (vendorRepository.exists(dto.getVendor().getId())) {
			Customer customer = repository.save(DTOConverter.getCustomer(dto));
			return customer.getId();
		} else {
			throw new VendorNotExistException(dto.getVendor().getId());
		}

	}

	@Override
	@ValidateWithOval
	public void updateCustomer(CustomerDTO dto) {
		if (repository.exists(dto.getId())) {

			if (vendorRepository.exists(dto.getVendor().getId())) {
				repository.save(DTOConverter.getCustomer(dto));
			} else {
				throw new VendorNotExistException(dto.getVendor().getId());
			}

		} else {
			throw new CustomerNotExistsException(dto.getId());
		}
	}

	@Override
	public void deleteCustomer(Long id) {
		if (repository.exists(id)) {
			repository.delete(id);
		} else {
			throw new CustomerNotExistsException(id);
		}
	}

}
