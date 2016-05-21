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
import com.app.messdeck.test.data.NameDTODataSample;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UnitTestConfigurationForControllers.class })
@WebAppConfiguration
public class TestNameDTO {

	@Autowired
	private Validator validator;

	private NameDTO dto;

	@Before
	public void setUp() throws Exception {
		dto = NameDTODataSample.getNameDTO_Owner();
	}

	@Test
	public void testInvalidFirstName() {
		dto.setFirstName("s23");
		List<ConstraintViolation> listOfVilolation = validator.validate(dto);
		assertEquals(1,listOfVilolation.size());
		assertEquals("Only Alphabets are allowed", listOfVilolation.get(0).getMessage());

	}
	
	@Test
	public void testInvalidLastName() {
		dto.setLastName("k23");
		List<ConstraintViolation> listOfVilolation = validator.validate(dto);
		assertEquals(1,listOfVilolation.size());
		assertEquals("Only Alphabets are allowed", listOfVilolation.get(0).getMessage());

	}
	
	@Test
	public void testNullFirstName() {
		dto.setFirstName(null);
		List<ConstraintViolation> listOfVilolation = validator.validate(dto);
		assertEquals(1,listOfVilolation.size());

	}
	
	@Test
	public void testNullLastName() {
		dto.setLastName(null);
		List<ConstraintViolation> listOfVilolation = validator.validate(dto);
		assertEquals(0,listOfVilolation.size());

	}
	
	

}
