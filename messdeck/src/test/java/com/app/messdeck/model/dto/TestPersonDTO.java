package com.app.messdeck.model.dto;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.app.messdeck.configuration.testenvconfig.UnitTestConfiguration;
import com.app.messdeck.testData.NameDTODataSample;
import com.app.messdeck.testData.PersonDTODataSample;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UnitTestConfiguration.class })
@WebAppConfiguration
public class TestPersonDTO {

	@Autowired
	private Validator validator;

	private PersonDTO dto;

	@Before
	public void setUp() throws Exception {
		dto = PersonDTODataSample.getPersonDTO();
	}

	@Test
	public void testInvalidMobileNumber() {
		dto.setMobileNo("1234");
		List<ConstraintViolation> listOfVilolation = validator.validate(dto);
		assertEquals(1, listOfVilolation.size());
		assertEquals("Invalid Mobile Number:Number should start with 7,8 or 9 & must be 10 digits",
				listOfVilolation.get(0).getMessage());
	}

	@Test
	public void testInvalidEmailID() {
		dto.setEmailID(new EmailIDDTO("shailesh"));
		List<ConstraintViolation> listOfVilolation = validator.validate(dto);
		assertEquals(1, listOfVilolation.size());
		assertEquals("com.app.messdeck.model.dto.PersonDTO.emailID is invalid", listOfVilolation.get(0).getMessage());

	}

	@Test
	public void testInvalidName() {
		dto.setName(new NameDTO("shailesh", "93"));
		List<ConstraintViolation> listOfVilolation = validator.validate(dto);
		assertEquals(1, listOfVilolation.size());
		assertEquals("com.app.messdeck.model.dto.PersonDTO.name is invalid", listOfVilolation.get(0).getMessage());

	}

	@Test
	public void testValidPerson() {

		List<ConstraintViolation> listOfVilolation = validator.validate(dto);
		assertEquals(0, listOfVilolation.size());

	}

}
