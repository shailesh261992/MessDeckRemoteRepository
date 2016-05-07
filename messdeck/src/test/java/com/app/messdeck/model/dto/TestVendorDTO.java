package com.app.messdeck.model.dto;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.app.messdeck.configuration.testenvconfig.UnitTestConfiguration;
import com.app.messdeck.testData.VendorDTODataSample;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UnitTestConfiguration.class })
@WebAppConfiguration
public class TestVendorDTO {

	@Autowired
	private Validator validator;

	private VendorDTO dto;

	@Before
	public void setUp() throws Exception {
		dto = VendorDTODataSample.getVendorDTO();
	}

	@Test
	public void testInvalidVendorName() {
		dto.setName("Sai 123");
		List<ConstraintViolation> listOfVilolation = validator.validate(dto);
		assertEquals(1, listOfVilolation.size());
		assertEquals("Only Alphabets are allowed", listOfVilolation.get(0).getMessage());
	}

	@Test
	public void testInvalidVendorAddress() {
		VendorAddressDTO vendorAddressDTO = new VendorAddressDTO();
		vendorAddressDTO.setCity("Satara");
		dto.setVendorAddress(vendorAddressDTO);
		List<ConstraintViolation> listOfVilolation = validator.validate(dto);
		assertEquals(1, listOfVilolation.size());
		assertEquals("Invalid Vendor Address", listOfVilolation.get(0).getMessage());
	}

	@Test
	public void testInvalidOwner() {
		OwnerDTO ownerDTO = new OwnerDTO();
		ownerDTO.setMobileNo("123");
		dto.setOwner(ownerDTO);
		List<ConstraintViolation> listOfVilolation = validator.validate(dto);
		assertEquals(1, listOfVilolation.size());
		assertEquals("Invalid Owner", listOfVilolation.get(0).getMessage());
	}

	@Test
	public void testValidVendor() {

		List<ConstraintViolation> listOfVilolation = validator.validate(dto);
		assertEquals(0, listOfVilolation.size());

	}

}
