package com.app.messdeck.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.messdeck.abstracttest.AbstractIntegrationTest;
import com.github.springtestdbunit.annotation.DatabaseSetup;

public class CustomerServiceIntegration extends AbstractIntegrationTest {

	@Autowired
	private CustomerService service;

	@Test
	@DatabaseSetup(value = { "/dbunit/testdata/VendorData.xml", "/dbunit/testdata/CustomersData.xml" })

	public void test() {
		// VendorDTO vendorSummary = service.getVendorSummary(1l);
		// assertThat(1l, is(equalTo(vendorSummary.getId())));
		// System.out.println(vendorSummary);
	}

}
