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

import com.app.messdeck.configuration.UnitTestConfiguration;
import com.app.messdeck.repository.testData.NameDTODataSample;
import com.app.messdeck.repository.testData.PersonDTODataSample;

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
		dto =PersonDTODataSample.getPersonDTO();
	}

	@Test
	public void testInvalidMobileNumber() {
		dto.setMobileNo("1234");
		List<ConstraintViolation> listOfVilolation = validator.validate(dto);
		assertEquals(1,listOfVilolation.size());
		assertEquals("Only Alphabets are allowed", listOfVilolation.get(0).getMessage());
	}

}
