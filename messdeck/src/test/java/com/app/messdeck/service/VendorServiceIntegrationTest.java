package com.app.messdeck.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.messdeck.abstracttest.AbstractIntegrationTest;
import com.app.messdeck.model.dto.VendorDTO;
import com.github.springtestdbunit.annotation.DatabaseSetup;

public class VendorServiceIntegrationTest extends AbstractIntegrationTest {

	@Autowired
	private VendorService service;

	@Test
	@DatabaseSetup(value = { "/dbunit/testdata/OwnersAddressData.xml", "/dbunit/testdata/OwnersData.xml",
			"/dbunit/testdata/VendorsAddress.xml", "/dbunit/testdata/VendorsData.xml" })

	public void test() {
		VendorDTO vendorSummary = service.getVendorSummary(1l);
		assertThat(1l, is(equalTo(vendorSummary.getId())));
		System.out.println(vendorSummary);
	}

}
