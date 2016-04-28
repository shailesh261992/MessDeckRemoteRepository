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

import com.app.messdeck.configuration.UnitTestConfiguration;
import com.app.messdeck.repository.testData.EmailIDDTODataSample;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UnitTestConfiguration.class })
@WebAppConfiguration
public class TestEmailIDDTO {

	@Autowired
	private Validator validator;

	private EmailIDDTO dto;

	@Before
	public void setUp() throws Exception {
		dto = EmailIDDTODataSample.getEmailIDDTO();
	}

	@Test
	public void testInvalidEmailID() {
		dto.setEmailId("shailesh@gmail");
		List<ConstraintViolation> listOfVilolation = validator.validate(dto);
		assertEquals(1, listOfVilolation.size());
		assertEquals("Invalid EmailID", listOfVilolation.get(0).getMessage());
	}

	@Test
	public void testNullEmailID() {
		dto.setEmailId(null);
		List<ConstraintViolation> listOfVilolation = validator.validate(dto);
		assertEquals(1, listOfVilolation.size());
		assertEquals("EmailID  can not be null", listOfVilolation.get(0).getMessage());
	}

	@Test
	public void testValidEmailID() {
		List<ConstraintViolation> listOfVilolation = validator.validate(dto);
		assertEquals(0, listOfVilolation.size());

	}

}
