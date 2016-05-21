package com.app.messdeck.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.app.messdeck.businessException.CustomerNotExistsException;
import com.app.messdeck.businessException.ValidationException;
import com.app.messdeck.businessException.VendorNotExistException;
import com.app.messdeck.configuration.testenvconfig.UnitTestConfigurationForServices;
import com.app.messdeck.entity.Customer;
import com.app.messdeck.model.dto.CustomerDTO;
import com.app.messdeck.model.dto.VendorDTO;
import com.app.messdeck.repository.CustomerDAO;
import com.app.messdeck.testData.CustomerDTODataSample;
import com.app.messdeck.utility.DTOConverter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UnitTestConfigurationForServices.class })
@WebAppConfiguration
public class TestCustomerServiceImpl {

	@Autowired
	private CustomerService service;

	@Autowired
	CustomerDAO daoMock;

	@Before
	public void setUp() throws Exception {
		Mockito.reset(daoMock);
	}

	@Test
	public void testCreateCustomer() {
		when(daoMock.create(any(Customer.class))).thenReturn(1l);
		Long customerID = service.createCustomer(CustomerDTODataSample.getCustomerDTO());
		System.out.println("custome id = " + customerID);

	}

	@Test(expected = ValidationException.class)
	public void testCreateCustomerWithInvalidData() {
		when(daoMock.create(any(Customer.class))).thenReturn(1l);
		CustomerDTO customerDTO = CustomerDTODataSample.getCustomerDTO();
		customerDTO.setMobileNo("123");
		service.createCustomer(customerDTO);

	}

	@Test(expected = Exception.class)
	public void testCreateCustomerWithNonExistingVendor() {
		when(daoMock.create(any(Customer.class))).thenThrow(new Exception());
		CustomerDTO customerDTO = CustomerDTODataSample.getCustomerDTO();
		customerDTO.setVendor(new VendorDTO());
		service.createCustomer(customerDTO);

	}

	@Test
	public void testGetCustomer() {
		when(daoMock.get(1)).thenReturn(DTOConverter.getCustomer(CustomerDTODataSample.getCustomerDTO()));
		CustomerDTO customerDTO = service.getCustomerSummary(1l);
		assertEquals(CustomerDTODataSample.getCustomerDTO().getName(), customerDTO.getName());
	}

	@Test(expected = CustomerNotExistsException.class)
	public void testGetNonExistingCustomer() {
		when(daoMock.get(1)).thenThrow(CustomerNotExistsException.class);
		service.getCustomerSummary(1l);

	}

	@Test()
	public void testDeleteCustomer() {
		when(daoMock.get(1)).thenReturn(DTOConverter.getCustomer(CustomerDTODataSample.getCustomerDTO()));
		doNothing().when(daoMock).delete(any(Customer.class));
		service.deleteCustomer(1l);
		verify(daoMock).get(1);
		verify(daoMock).delete(any(Customer.class));

	}

	@Test(expected = CustomerNotExistsException.class)
	public void testDeleteNonExistingCustomer() {
		when(daoMock.get(1)).thenThrow(CustomerNotExistsException.class);
		service.deleteCustomer(1l);

	}

	@Test()
	public void testUpdateCustomer() {
		CustomerDTO customerDTO = CustomerDTODataSample.getCustomerDTO();
		customerDTO.setId(1);
		customerDTO.setMobileNo("9876598765");
		doNothing().when(daoMock).update(DTOConverter.getCustomer(customerDTO));

	}

	@Test(expected = CustomerNotExistsException.class)
	public void testUpdateNonExistingCustomer() {
		CustomerDTO customerDTO = CustomerDTODataSample.getCustomerDTO();
		customerDTO.setId(1);
		customerDTO.setMobileNo("9876598765");
		doThrow(CustomerNotExistsException.class).when(daoMock).update(DTOConverter.getCustomer(customerDTO));
		service.updateCustomer(customerDTO);

	}

	@Test(expected = VendorNotExistException.class)
	public void testUpdateNonExistingVendorReferredByCustomer() {
		CustomerDTO customerDTO = CustomerDTODataSample.getCustomerDTO();
		customerDTO.setId(1);
		doThrow(VendorNotExistException.class).when(daoMock).update(DTOConverter.getCustomer(customerDTO));
		service.updateCustomer(customerDTO);

	}
}
