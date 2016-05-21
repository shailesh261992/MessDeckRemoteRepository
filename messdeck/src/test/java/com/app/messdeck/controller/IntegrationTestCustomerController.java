package com.app.messdeck.controller;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.app.messdeck.configuration.testenvconfig.IntegrationTestConfiguration;
import com.app.messdeck.model.dto.CustomerDTO;
import com.app.messdeck.testData.CustomerDTODataSample;
import com.app.messdeck.testData.IntegrationTestData;
import com.app.messdeck.testutils.TestUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { IntegrationTestConfiguration.class })
@WebAppConfiguration
public class IntegrationTestCustomerController {

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype());

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private IntegrationTestData testData;
	
	@PostConstruct
	public void init(){
		testData.initializeTestData();
	}


	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

	}

	@Test
	public void testGetCustomerSummary() throws Exception {

		mockMvc.perform(get("/customers/1").accept(contentType)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.name.firstName", is("Ganesh")))
				.andExpect(jsonPath("$.links[*].rel", containsInAnyOrder("self")));
	}

	@Test
	public void testGetCustomerSummaryForNonExistingCustomer() throws Exception {

		mockMvc.perform(get("/customers/17171717").accept(contentType)).andDo(print())
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testCreateCustomer() throws Exception {

		CustomerDTO customerDTO = CustomerDTODataSample.getCustomerDTO();
		customerDTO.getVendor().setId(1);
		mockMvc.perform(post("/customers").contentType(contentType).accept(contentType)
				.content(TestUtils.convertObjectToJsonString(customerDTO))).andDo(print())
				.andExpect(status().isCreated());
	}

	@Test
	public void testCreateCustomerWithInvalidData() throws IOException, Exception {

		CustomerDTO customerDTO = CustomerDTODataSample.getCustomerDTO();
		customerDTO.getVendor().setId(1);
		customerDTO.setMobileNo("123");

		mockMvc.perform(post("/customers").contentType(contentType).accept(contentType)
				.content(TestUtils.convertObjectToJsonString(customerDTO))).andExpect(status().isBadRequest())
				.andExpect(jsonPath("$[*].fieldName", containsInAnyOrder("mobileNo"))).andDo(print());

	}

	@Test
	public void testCreateCustomerWithNonExistingVendor() throws IOException, Exception {

		CustomerDTO customerDTO = CustomerDTODataSample.getCustomerDTO();
		customerDTO.getVendor().setId(Integer.MAX_VALUE);
		mockMvc.perform(post("/customers").contentType(contentType).accept(contentType)
				.content(TestUtils.convertObjectToJsonString(customerDTO))).andDo(print());

	}

	@Test()
	public void testDeleteCustomer() throws Exception {
		mockMvc.perform(delete("/customers/2")).andDo(print()).andExpect(status().isNoContent());

	}

	@Test()
	public void testDeleteNonExistingCustomer() throws Exception {
		mockMvc.perform(delete("/customers/" + Integer.MAX_VALUE)).andDo(print()).andExpect(status().isBadRequest());

	}

	@Test()
	public void testUpdateCustomer() throws IOException, Exception {

		MvcResult result = mockMvc.perform(get("/customers/3").accept(contentType)).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String content = response.getContentAsString();

		CustomerDTO customerDTO = (CustomerDTO) TestUtils.convertJsonToObject(content, CustomerDTO.class);
		customerDTO.setMobileNo("9898676776");
		mockMvc.perform(
				put("/customers/3").contentType(contentType).content(TestUtils.convertObjectToJsonString(customerDTO)))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.mobileNo", is("9898676776")));

	}

	@Test
	public void testUpdateNonExistingCustomer() throws IOException, Exception {
		CustomerDTO customerDTO = CustomerDTODataSample.getCustomerDTO();
		customerDTO.setMobileNo("9876598765");
		customerDTO.getVendor().setId(1);

		mockMvc.perform(put("/customers/" + Integer.MAX_VALUE).contentType(contentType)
				.content(TestUtils.convertObjectToJsonString(customerDTO))).andDo(print())
				.andExpect(status().isBadRequest());

	}

	@Test()
	public void testUpdateNonExistingVendorReferredByCustomer() throws IOException, Exception {
		MvcResult result = mockMvc.perform(get("/customers/3").accept(contentType)).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String content = response.getContentAsString();

		CustomerDTO customerDTO = (CustomerDTO) TestUtils.convertJsonToObject(content, CustomerDTO.class);
		customerDTO.setMobileNo("9898676776");
		customerDTO.getVendor().setId(Integer.MAX_VALUE);
		mockMvc.perform(
				put("/customers/3").contentType(contentType).content(TestUtils.convertObjectToJsonString(customerDTO)))
				.andDo(print());

	}

}
