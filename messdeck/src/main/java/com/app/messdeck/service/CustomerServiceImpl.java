package com.app.messdeck.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.messdeck.model.dto.CustomerDTO;
import com.app.messdeck.repository.CustomerDAO;
import com.app.messdeck.utility.DTOConverter;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO dao;

	@Override
	public CustomerDTO getCustomer(Long id) {

		// Long id2 = this.createCustomer(createCustomerDTO());
		return DTOConverter.EntityToDTOConverter(dao.read(id));

	}

	@Override
	public Long createCustomer(CustomerDTO dto) {
		System.out.println("*** creating dto " + dto);
		Long id = dao.create(DTOConverter.DTOToEntityCoverter(dto));
		System.out.println("Created object with id " + id);
		return id;

	}

	@Override
	public void updateCustomer(CustomerDTO dto) {
		dao.update(DTOConverter.DTOToEntityCoverter(dto));
	}

	@Override
	public void deleteCustomer(Long id) {
		dao.delete(dao.read(id));

	}

	// private CustomerDTO createCustomerDTO() {
	// CustomerDTO dto = new CustomerDTO();
	//
	// Address address = new Address();
	// address.setCity("Pune");
	// dto.setAddress(address);
	//
	// dto.setEmailID(new EmailID("Shailesh444@gmail.com"));
	// dto.setGender(Gender.MALE);
	// dto.setMobileNo("8765234");
	// dto.setName(new Name("Teja", "Thakur"));
	// dto.setVendorID(1);
	//
	// return dto;
	//
	// }

}
