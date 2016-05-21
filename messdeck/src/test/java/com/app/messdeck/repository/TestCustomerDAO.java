package com.app.messdeck.repository;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.app.messdeck.businessException.CustomerNotExistsException;
import com.app.messdeck.businessException.VendorNotExistException;
import com.app.messdeck.configuration.MessDeckConfiguration;
import com.app.messdeck.entity.Customer;
import com.app.messdeck.entity.CustomerAddress;
import com.app.messdeck.entity.Vendor;
import com.app.messdeck.model.dto.CustomerDTO;
import com.app.messdeck.testData.CustomerDTODataSample;
import com.app.messdeck.testData.VendorDTODataSample;
import com.app.messdeck.utility.DTOConverter;
import com.app.messdeck.utility.EntityConverter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MessDeckConfiguration.class })
@WebAppConfiguration
public class TestCustomerDAO {

	@Autowired
	private CustomerDAO dao;

	@Autowired
	VendorDAO vendorDao;

	@Autowired
	private HibernateTemplate template;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	@Transactional
	public void tesCreate() {
		Vendor vendor = DTOConverter.getVendor(VendorDTODataSample.getVendorDTO());
		Long vendorId = vendorDao.create(vendor);
		vendor.setId(vendorId);
		CustomerDTO dto = CustomerDTODataSample.getCustomerDTO();
		dto.setVendor(EntityConverter.getVendorSummaryDTO(vendor));
		Customer customer = DTOConverter.getCustomer(dto);
		dao.create(customer);
		assertEquals(dao.getAll().size(), 1);
		assertEquals(1, template.loadAll(CustomerAddress.class).size());
	}

	@Test(expected = VendorNotExistException.class)
	@Transactional
	public void tesCreateWithNonExistingVendor() {
		Vendor vendor = DTOConverter.getVendor(VendorDTODataSample.getVendorDTO());
		CustomerDTO dto = CustomerDTODataSample.getCustomerDTO();
		dto.setVendor(EntityConverter.getVendorSummaryDTO(vendor));
		Customer customer = DTOConverter.getCustomer(dto);
		dao.create(customer);
		// assertEquals(dao.getAll().size(), 1);
		// assertEquals(1, template.loadAll(CustomerAddress.class).size());
	}

	@Test(expected = DataIntegrityViolationException.class)
	@Transactional
	public void testCreateWithExistingEmailID() {
		Vendor vendor = DTOConverter.getVendor(VendorDTODataSample.getVendorDTO());
		Long vendorId = vendorDao.create(vendor);
		vendor.setId(vendorId);
		CustomerDTO dto = CustomerDTODataSample.getCustomerDTO();
		dto.setVendor(EntityConverter.getVendorSummaryDTO(vendor));
		Customer customer1 = DTOConverter.getCustomer(dto);
		Customer customer2 = DTOConverter.getCustomer(dto);

		dao.create(customer1);
		dao.create(customer2);

	}

	@Test
	@Transactional
	public void testGet() {
		Vendor vendor = DTOConverter.getVendor(VendorDTODataSample.getVendorDTO());
		Long vendorId = vendorDao.create(vendor);
		vendor.setId(vendorId);
		CustomerDTO dto = CustomerDTODataSample.getCustomerDTO();
		dto.setVendor(EntityConverter.getVendorSummaryDTO(vendor));
		Customer c = DTOConverter.getCustomer(dto);
		Long id = dao.create(c);

		Customer customer = dao.get(id);
		assertEquals(customer.getName(), c.getName());
		assertEquals(customer.getCustomerAddress(), c.getCustomerAddress());
	}

	@Test(expected = CustomerNotExistsException.class)
	@Transactional
	public void testGetForNonExistentCustomer() {

		dao.get(1);

	}

	@Test
	@Transactional
	public void testDelete() {
		Vendor vendor = DTOConverter.getVendor(VendorDTODataSample.getVendorDTO());
		Long vendorId = vendorDao.create(vendor);
		vendor.setId(vendorId);
		CustomerDTO dto = CustomerDTODataSample.getCustomerDTO();
		dto.setVendor(EntityConverter.getVendorSummaryDTO(vendor));
		Customer c = DTOConverter.getCustomer(dto);
		Long id = dao.create(c);
		Customer customer = dao.get(id);

		dao.delete(customer);
		assertEquals(0, template.loadAll(Customer.class).size());
		assertEquals(0, template.loadAll(CustomerAddress.class).size());
		assertEquals(1, template.loadAll(Vendor.class).size());

	}

	@Test
	@Transactional
	public void testUpdate() {
		Vendor vendor = DTOConverter.getVendor(VendorDTODataSample.getVendorDTO());
		Long vendorId = vendorDao.create(vendor);
		vendor.setId(vendorId);
		CustomerDTO dto = CustomerDTODataSample.getCustomerDTO();
		dto.setVendor(EntityConverter.getVendorSummaryDTO(vendor));
		Customer c = DTOConverter.getCustomer(dto);
		Long id = dao.create(c);
		Customer customer = dao.get(id);
		customer.setMobileNo("8877887788");
		dao.update(customer);

		assertEquals(customer.getMobileNo(), dao.get(id).getMobileNo());

	}

}
