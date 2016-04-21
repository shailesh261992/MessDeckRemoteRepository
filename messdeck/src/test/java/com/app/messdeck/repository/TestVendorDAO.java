package com.app.messdeck.repository;

import static com.app.messdeck.repository.testData.SampleVendorData.getVendorOne;
import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.app.messdeck.configuration.MessDeckConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MessDeckConfiguration.class })
@WebAppConfiguration
public class TestVendorDAO {

	@Autowired
	private VendorDAO dao;

	@Test
	@Rollback(true)
	@Transactional
	public void create() {
		dao.create(getVendorOne());
		assertEquals(1, dao.getAll().size());
	}

	@Test
	@Rollback(true)
	@Transactional
	public void create2() {
		dao.create(getVendorOne());
		assertEquals(1, dao.getAll().size());
	}

}
