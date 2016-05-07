package com.app.messdeck.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.app.messdeck.businessException.ValidationException;
import com.app.messdeck.configuration.testenvconfig.IntegrationTestConfiguration;
import com.app.messdeck.entity.EmailID;
import com.app.messdeck.model.dto.EmailIDDTO;
import com.app.messdeck.model.dto.ValidationErrrorInfo;
import com.app.messdeck.model.dto.VendorDTO;
import com.app.messdeck.testData.IntegrationTestData;
import com.app.messdeck.testData.VendorDTODataSample;
import com.app.messdeck.testutils.TestUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { IntegrationTestConfiguration.class })
@WebAppConfiguration
public class IntegrationTestVendorController {

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype());

	// @Autowired
	// IntegrationTestData data;

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		// data.initializeTestData();
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

	}

	@Test
	public void testGetVendorSummary() throws Exception {
		System.out.println("*** testGetVendorSummary start  ****");
		mockMvc.perform(get("/vendors/1")).andExpect(status().isOk()).andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.name", is("Sai Mess")))
				.andExpect(jsonPath("$.vendorAddress.pinCode", is("410507"))).andDo(print());
		System.out.println("*** testGetVendorSummary end ****");
	}

	@Test
	public void testGetVendorSummaryForNonExistingVendor() throws Exception {
		System.out.println("*** testGetVendorSummaryForNonExistingVendor start  ****");
		mockMvc.perform(get("/vendors/15")).andExpect(status().isBadRequest()).andDo(print());
		System.out.println("*** testGetVendorSummaryForNonExistingVendor end ****");

	}

	@Test
	@Rollback(true)
	public void testCreateVendor() throws Exception {
		System.out.println("*** testCreateVendor start  ****");
		VendorDTO vendor = VendorDTODataSample.getVendorDTO();
		vendor.setName("Arya mess");
		vendor.getOwner().setEmailID(new EmailIDDTO("arya@gmail.com"));

		System.out.println("Vendor json = " + TestUtils.convertObjectToJsonString(vendor));

		mockMvc.perform(post("/vendors").contentType(contentType).content(TestUtils.convertObjectToJsonString(vendor)))
				.andExpect(status().isCreated()).andDo(print());

		System.out.println("*** testCreateVendor end ****");

	}

	@Test
	public void testCreateVendorWithConstraintViolation() throws Exception {
		System.out.println("*** testCreateVendorWithConstraintViolation start  ****");
		VendorDTO vendor = VendorDTODataSample.getVendorDTO();

		vendor.setName("Sai9 Dhaba");
		vendor.getOwner().setEmailID(new EmailIDDTO("sai9@gmail.com"));

		List<ValidationErrrorInfo> errorInfoList = new ArrayList<>();
		ValidationErrrorInfo validationErrrorInfo = new ValidationErrrorInfo();
		validationErrrorInfo.setFieldName("name");
		validationErrrorInfo.setErrorMessage("Inavlide Vendor Name");
		errorInfoList.add(validationErrrorInfo);

		ValidationException exception = new ValidationException(errorInfoList);

		mockMvc.perform(post("/vendors").contentType(contentType).content(TestUtils.convertObjectToJsonString(vendor)))
				.andDo(print());

		System.out.println("*** testCreateVendorWithConstraintViolation end ****");

	}

}
