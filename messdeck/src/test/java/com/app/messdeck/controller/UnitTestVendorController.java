package com.app.messdeck.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Any;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.app.messdeck.businessException.ValidationException;
import com.app.messdeck.businessException.VendorNotExistException;
import com.app.messdeck.configuration.testenvconfig.UnitTestConfiguration;
import com.app.messdeck.model.dto.ValidationErrrorInfo;
import com.app.messdeck.model.dto.VendorDTO;
import com.app.messdeck.service.VendorService;
import com.app.messdeck.testData.VendorDTODataSample;
import com.app.messdeck.testutils.TestUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UnitTestConfiguration.class })
@WebAppConfiguration

public class UnitTestVendorController {

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype());
	@Autowired
	VendorService serviceMock;

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		Mockito.reset(serviceMock);
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

	}

	@Test
	public void testGetVendorSummary() throws Exception {
		VendorDTO vendor = new VendorDTO();
		vendor.setId(1);
		vendor.setName("Sai Dhaba");
		when(serviceMock.getVendorSummary(1l)).thenReturn(vendor);

		mockMvc.perform(get("/vendors/1")).andExpect(status().isOk()).andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$.id", is(1))).andExpect(jsonPath("$.name", is("Sai Dhaba")))
				.andExpect(jsonPath("$.links[0].rel", is("self"))).andDo(print());

	}

	@Test
	public void testGetVendorSummaryForNonExistingVendor() throws Exception {
		VendorDTO vendor = VendorDTODataSample.getVendorDTO();
		vendor.setId(1);
		vendor.setName("Sai Dhaba");

		when(serviceMock.getVendorSummary(1l)).thenThrow(new VendorNotExistException(1));
		mockMvc.perform(get("/vendors/1")).andExpect(status().isBadRequest()).andDo(print());

	}

	//
	// @Test
	// public void testCreateVendorWithAlreadyExistingEmailID() throws Exception
	// {
	// VendorDTO vendor = VendorDTODataSample.getVendorDTO();
	// vendor.setId(1);
	// vendor.setName("Sai Dhaba");
	//
	//// when(serviceMock.getVendorSummary(1l)).thenReturn(vendor).thenThrow(new
	// DataIntegrityViolationException(
	//// "Vendor with email ID " + vendor.getOwner().getEmailID() + "already
	// exist"));
	//
	// when(serviceMock.createVendor(vendor)).thenThrow(throwableType)
	//
	// mockMvc.perform(get("/vendors/1")).andExpect(status().isOk()).andExpect(content().contentType(contentType))
	// .andExpect(jsonPath("$.id", is(1))).andExpect(jsonPath("$.name", is("Sai
	// Dhaba")))
	// .andExpect(jsonPath("$.links[0].rel", is("self"))).andDo(print());
	//
	// mockMvc.perform(get("/vendors/1")).andExpect(status().isBadRequest()).andDo(print());
	//
	// }

	@Test
	public void testCreateVendor() throws Exception {
		VendorDTO vendor = VendorDTODataSample.getVendorDTO();

		when(serviceMock.createVendor(vendor)).thenReturn(1l);

		mockMvc.perform(post("/vendors").contentType(contentType).content(TestUtils.convertObjectToJsonString(vendor)))
				.andExpect(status().isCreated()).andDo(print());

	}

	@Test
	public void testCreateVendorWithConstraintViolation() throws Exception {
		VendorDTO vendor = VendorDTODataSample.getVendorDTO();
		vendor.setId(1);
		vendor.setName("Sai9 Dhaba");

		List<ValidationErrrorInfo> errorInfoList = new ArrayList<>();
		ValidationErrrorInfo validationErrrorInfo = new ValidationErrrorInfo();
		validationErrrorInfo.setFieldName("name");
		validationErrrorInfo.setErrorMessage("Inavlide Vendor Name");
		errorInfoList.add(validationErrrorInfo);

		ValidationException exception = new ValidationException(errorInfoList);
		when(serviceMock.createVendor(vendor)).thenThrow(exception);

		mockMvc.perform(post("/vendors").contentType(contentType).content(TestUtils.convertObjectToJsonString(vendor)))
				.andExpect(status().isBadRequest()).andDo(print());

	}

	@Test
	public void testVendorDelete() throws Exception {
		doNothing().when(serviceMock).deleteVendor(1l);
		;

		mockMvc.perform(delete("/vendors/1")).andExpect(status().isNoContent()).andDo(print());

	}

	@Test
	public void testVendorDeleteWithNonExistingVendor() throws Exception {
		doThrow(VendorNotExistException.class).when(serviceMock).deleteVendor(1l);
		;

		mockMvc.perform(delete("/vendors/1")).andExpect(status().isBadRequest()).andDo(print());

	}

}
