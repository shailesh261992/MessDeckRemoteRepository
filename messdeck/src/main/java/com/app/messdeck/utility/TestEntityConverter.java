package com.app.messdeck.utility;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.app.messdeck.entity.Vendor;
import com.app.messdeck.model.dto.VendorDTO;
import com.app.messdeck.testData.VendorDTODataSample;

public class TestEntityConverter {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetVendorSummaryDTO() {
		Vendor vendor = VendorDTODataSample.getEquivalentVendor();
		VendorDTO dto = EntityConverter.getVendorSummaryDTO(vendor);
		assertNull(dto.getOwner());
		assertNull(dto.getServices());
		assertNull(dto.getCustomers());
		
	}
	

	@Test
	public void testGetVendorDetailsDTO() {
		Vendor vendor = VendorDTODataSample.getEquivalentVendor();
		VendorDTO dto = EntityConverter.getVendorDetailsDTO(vendor);
		assertNull(dto.getServices());
		assertNull(dto.getCustomers());
		
	}

}
