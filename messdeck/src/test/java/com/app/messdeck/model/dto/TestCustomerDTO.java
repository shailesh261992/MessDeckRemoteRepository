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

import com.app.messdeck.configuration.testenvconfig.UnitTestConfigurationForControllers;
import com.app.messdeck.test.data.CustomerDTODataSample;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UnitTestConfigurationForControllers.class })
@WebAppConfiguration
public class TestCustomerDTO {

	@Autowired
	private Validator validator;

	private CustomerDTO dto;

	@Before
	public void setUp() throws Exception {
		dto = CustomerDTODataSample.getCustomerDTO();
	}

	@Test
	public void testInvalidCustomerName() {
		dto.setName(new NameDTO("shaggy19", "Kadam"));
		List<ConstraintViolation> listOfVilolation = validator.validate(dto);
		assertEquals(1, listOfVilolation.size());
		assertEquals("com.app.messdeck.model.dto.PersonDTO.name is invalid", listOfVilolation.get(0).getMessage());
	}

	@Test
	public void testInvalidCustomerAddress() {
		CustomerAddressDTO customerAddress = dto.getCustomerAddress();
		customerAddress.setCity("satara");
		List<ConstraintViolation> listOfVilolation = validator.validate(dto);
		assertEquals(1, listOfVilolation.size());
		assertEquals("Invalid Customer Address", listOfVilolation.get(0).getMessage());
	}
	
	

}
