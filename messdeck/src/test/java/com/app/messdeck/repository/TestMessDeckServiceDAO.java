package com.app.messdeck.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.app.messdeck.businessException.MessDeckServiceInfoNotExistException;
import com.app.messdeck.businessException.VendorNotExistException;
import com.app.messdeck.configuration.MessDeckConfiguration;
import com.app.messdeck.entity.Item;
import com.app.messdeck.entity.MessDeckServiceInfo;
import com.app.messdeck.entity.Vendor;
import com.app.messdeck.test.data.MessDeckServiceInfoDTODataSample;
import com.app.messdeck.test.data.VendorDTODataSample;
import com.app.messdeck.utility.DTOConverter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MessDeckConfiguration.class })
@WebAppConfiguration
public class TestMessDeckServiceDAO {
	@Autowired
	VendorDAO vendorDao;

	@Autowired
	MessDeckServiceInfoDAO dao;

	@Autowired
	private HibernateTemplate template;

	MessDeckServiceInfo messDeckService;

	@Before
	public void setUp() throws Exception {
		messDeckService = DTOConverter
				.getMessDeckServiceInfo(MessDeckServiceInfoDTODataSample.getMessDeckServiceInfoDTO());
	}

	@Test
	@Transactional
	public void testCreate() {
		Vendor vendor = DTOConverter.getVendor(VendorDTODataSample.getVendorDTO());
		Long vendorId = vendorDao.create(vendor);
		vendor.setId(vendorId);
		messDeckService.setVendor(vendor);
		dao.create(messDeckService);
		assertEquals(1, template.loadAll(MessDeckServiceInfo.class).size());
		assertTrue(template.loadAll(Item.class).size() >= 1);

	}

	@Test(expected = VendorNotExistException.class)
	@Transactional
	public void tesCreateWithNonExistingVendor() {
		messDeckService.setVendor(new Vendor());
		dao.create(messDeckService);

	}

	@Test
	@Transactional
	public void testGet() {

		Vendor vendor = DTOConverter.getVendor(VendorDTODataSample.getVendorDTO());
		Long vendorId = vendorDao.create(vendor);
		vendor.setId(vendorId);
		messDeckService.setVendor(vendor);
		Long id = dao.create(messDeckService);

		MessDeckServiceInfo fetchedService = dao.get(id);
		assertEquals(messDeckService, fetchedService);

	}

	@Test(expected = MessDeckServiceInfoNotExistException.class)
	@Transactional
	public void testGetForNonExistingMessDeckService() {
		dao.get(Long.MAX_VALUE);
	}

	@Test(expected = MessDeckServiceInfoNotExistException.class)
	@Transactional
	public void testDelete() {
		Vendor vendor = DTOConverter.getVendor(VendorDTODataSample.getVendorDTO());
		Long vendorId = vendorDao.create(vendor);
		vendor.setId(vendorId);
		messDeckService.setVendor(vendor);
		Long id = dao.create(messDeckService);
		dao.delete(id);
		dao.get(id);
	}

	@Test(expected = MessDeckServiceInfoNotExistException.class)
	@Transactional
	public void testDeleteForNonExistingService() {
		dao.delete(Long.MAX_VALUE);
	}

	@Test
	@Transactional
	public void testUpdate() {
		Vendor vendor = DTOConverter.getVendor(VendorDTODataSample.getVendorDTO());
		Long vendorId = vendorDao.create(vendor);
		vendor.setId(vendorId);
		messDeckService.setVendor(vendor);
		Long id = dao.create(messDeckService);

		MessDeckServiceInfo updatedMessDeckService = dao.get(id);
		updatedMessDeckService.setCost(499);
		dao.update(updatedMessDeckService);

		assertEquals(updatedMessDeckService, dao.get(id));
	}

	@Test(expected = MessDeckServiceInfoNotExistException.class)
	@Transactional
	public void testUpdateNonExistingMessDeckService() {
		Vendor vendor = DTOConverter.getVendor(VendorDTODataSample.getVendorDTO());
		Long vendorId = vendorDao.create(vendor);
		vendor.setId(vendorId);
		messDeckService.setVendor(vendor);

		messDeckService.setId(Long.MAX_VALUE);
		dao.update(messDeckService);
	}

}
