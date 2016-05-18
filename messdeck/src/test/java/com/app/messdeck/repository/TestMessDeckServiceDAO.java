package com.app.messdeck.repository;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.app.messdeck.businessException.VendorNotExistException;
import com.app.messdeck.configuration.MessDeckConfiguration;
import com.app.messdeck.entity.Item;
import com.app.messdeck.entity.MessDeckService;
import com.app.messdeck.entity.Vendor;
import com.app.messdeck.testData.MessDeckServiceDTODataSample;
import com.app.messdeck.testData.VendorDTODataSample;
import com.app.messdeck.utility.DTOConverter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MessDeckConfiguration.class })
@WebAppConfiguration
public class TestMessDeckServiceDAO {
	@Autowired
	VendorDAO vendorDao;

	@Autowired
	MessDeckServiceDAO dao;

	@Autowired
	private HibernateTemplate template;

	MessDeckService messDeckService;

	@Before
	public void setUp() throws Exception {
		messDeckService = DTOConverter.getMessDeckService(MessDeckServiceDTODataSample.getMessDeckServiceDTO());
	}

	@Test
	@Transactional
	public void testCreate() {
		Vendor vendor = DTOConverter.getVendor(VendorDTODataSample.getVendorDTO());
		Long vendorId = vendorDao.create(vendor);
		vendor.setId(vendorId);
		messDeckService.setVendor(vendor);
		dao.create(messDeckService);
		assertEquals(1, template.loadAll(MessDeckService.class).size());
		assertTrue(template.loadAll(Item.class).size() >= 1);

	}

	@Test(expected = VendorNotExistException.class)
	@Transactional
	public void tesCreateWithNonExistingVendor() {
		messDeckService.setVendor(new Vendor());
		dao.create(messDeckService);

	}

}
