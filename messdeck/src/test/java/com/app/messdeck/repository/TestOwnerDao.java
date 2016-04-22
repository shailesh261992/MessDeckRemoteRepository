package com.app.messdeck.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.app.messdeck.configuration.MessDeckConfiguration;
import com.app.messdeck.repository.testData.SampleVendorData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MessDeckConfiguration.class })
@WebAppConfiguration
public class TestOwnerDao {

	@Autowired
	private OwnerDAOImpl dao;

	@Test
	public void test() {
		dao.create(SampleVendorData.getVendorOne().getOwner());
	}

}
