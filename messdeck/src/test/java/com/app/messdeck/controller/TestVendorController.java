package com.app.messdeck.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

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

import com.app.messdeck.configuration.UnitTestConfiguration;
import com.app.messdeck.model.dto.VendorDTO;
import com.app.messdeck.repository.testData.VendorDTODataSample;
import com.app.messdeck.service.VendorService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UnitTestConfiguration.class })
@WebAppConfiguration

public class TestVendorController {

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
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
	public void testVendorCreate() throws Exception {
		VendorDTO vendor = new VendorDTO();
		vendor.setId(1);
		vendor.setName("Sai Dhaba");
		when(serviceMock.getVendorSummary(1l)).thenReturn(vendor);

		mockMvc.perform(get("/vendors/1")).andExpect(status().isOk()).andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$.id", is(1))).andExpect(jsonPath("$.name", is("Sai Dhaba")))
				.andExpect(jsonPath("$.links[0].rel", is("self"))).andDo(print());

	}

//	@Test
//	public void testVendorCreateWithExistingEmailID() throws Exception {
//		VendorDTO vendor = VendorDTODataSample.getVendorDTO();
//		
//
//		when(serviceMock.getVendorSummary(1l)).thenReturn(vendor)
//				.thenThrow(new DataIntegrityViolationException("Vendor with email ID  " + vendor.getOwner().getEmailID() + "already exist"));
//
//		mockMvc.perform(get("/vendors/1")).andExpect(status().isOk()).andExpect(content().contentType(contentType))
//				.andExpect(jsonPath("$.id", is(1))).andExpect(jsonPath("$.name", is("Sai Dhaba")))
//				.andExpect(jsonPath("$.links[0].rel", is("self"))).andDo(print());
//
//		mockMvc.perform(get("/vendors/1")).andDo(print());
//
//	}
}
