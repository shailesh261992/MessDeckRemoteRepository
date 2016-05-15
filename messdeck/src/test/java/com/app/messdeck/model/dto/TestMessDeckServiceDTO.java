package com.app.messdeck.model.dto;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.common.test.reflection.java.generics.Dad;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.app.messdeck.configuration.testenvconfig.UnitTestConfigurationForControllers;
import com.app.messdeck.testData.MessDeckServiceDTODataSample;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UnitTestConfigurationForControllers.class })
@WebAppConfiguration
public class TestMessDeckServiceDTO {

	@Autowired
	private Validator validator;

	private MessDeckServiceDTO dto;

	@Before
	public void setUp() throws Exception {
		dto = MessDeckServiceDTODataSample.getMessDeckServiceDTO();
	}

	@Test
	public void testNullVendor() {
		dto.setVendor(null);
		List<ConstraintViolation> listOfVilolation = validator.validate(dto);
		assertEquals("Vendor can not be null,Only vendors are allowed to publish service",
				listOfVilolation.get(0).getMessage());

	}

	@Test
	public void testInalidCapacityOfMembers() {
		dto.setCapacityOfMembers(-1);
		List<ConstraintViolation> listOfVilolation = validator.validate(dto);
		assertEquals("Member Capacity must be greater than 0(Zero)", listOfVilolation.get(0).getMessage());

	}

	@Test
	public void testInalidCost() {
		dto.setCost(-1);
		List<ConstraintViolation> listOfVilolation = validator.validate(dto);
		assertEquals("Cost must be greater than 0(Zero)", listOfVilolation.get(0).getMessage());

	}

	@Test
	public void testValidMessDeckService() {
		List<ConstraintViolation> listOfVilolation = validator.validate(dto);
		assertEquals(0, listOfVilolation.size());

	}

	// @Test
	// public void testInvalidDate_DateBeforeCurrentDate() {
	// Date d = new Date();
	//
	// List<ConstraintViolation> listOfVilolation = validator.validate(dto);
	// assertEquals("Vendor can not be null,Only vendors are allowed to publish
	// service",
	// listOfVilolation.get(0).getMessage());
	//
	// }

}
