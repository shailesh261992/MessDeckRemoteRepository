package com.app.messdeck.model.dto;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.app.messdeck.configuration.testenvconfig.UnitTestConfiguration;
import com.app.messdeck.testData.AddressDTODataSample;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UnitTestConfiguration.class })
@WebAppConfiguration
public class TestAddressDTO {

	@Autowired
	private Validator validator;

	private AddressDTO dto;

	@Before
	public void setUp() throws Exception {
		dto = AddressDTODataSample.getAddressDTO();
	}

	@Test
	public void testInvalidPincode() {
		dto.setPinCode("10507");
		List<ConstraintViolation> listOfVilolation = validator.validate(dto);
		assertEquals(1,listOfVilolation.size());
		assertEquals("Invalid Pincode", listOfVilolation.get(0).getMessage());
	}
	

	@Test
	public void testInvalidCountry() {
		dto.setCountry("In");
		List<ConstraintViolation> listOfVilolation = validator.validate(dto);
		assertEquals(1,listOfVilolation.size());
		assertEquals("Only Supported in India. Valid values list [India]", listOfVilolation.get(0).getMessage());
	}
	
	@Test
	public void testInvalidState() {
		dto.setState("maharashtraa");
		List<ConstraintViolation> listOfVilolation = validator.validate(dto);
		assertEquals(1,listOfVilolation.size());
		assertEquals("Only Supported in Maharashtra. Valid values list [Maharashtra]", listOfVilolation.get(0).getMessage());
	}
	

	@Test
	public void testInvalidCity() {
		dto.setCity("satara");
		List<ConstraintViolation> listOfVilolation = validator.validate(dto);
		assertEquals(1,listOfVilolation.size());
		assertEquals("Only Supported in Pune. Valid values list [Pune]", listOfVilolation.get(0).getMessage());
	}
	
	
	@Test
	public void testValidAddressDTO() {
		List<ConstraintViolation> listOfVilolation = validator.validate(dto);
		assertEquals(0,listOfVilolation.size());
	}

}