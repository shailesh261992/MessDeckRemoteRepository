package com.app.messdeck.controller;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

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

import com.app.messdeck.configuration.testenvconfig.IntegrationTestConfiguration;
import com.app.messdeck.model.dto.EmailIDDTO;
import com.app.messdeck.model.dto.VendorDTO;
import com.app.messdeck.testData.VendorDTODataSample;
import com.app.messdeck.testutils.TestUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { IntegrationTestConfiguration.class })
@WebAppConfiguration
public class IntegrationTestVendorController {

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype());

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {

		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

	}

	@Test
	public void testGetVendorSummary() throws Exception {
		System.out.println("*** testGetVendorSummary start  ****");
		mockMvc.perform(get("/vendors/1")).andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.name", is("Sai Mess")))
				.andExpect(jsonPath("$.vendorAddress.pinCode", is("410507")));
		System.out.println("*** testGetVendorSummary end ****");
	}

	@Test
	public void testGetVendorSummaryForNonExistingVendor() throws Exception {
		System.out.println("*** testGetVendorSummaryForNonExistingVendor start  ****");
		mockMvc.perform(get("/vendors/15")).andDo(print()).andExpect(status().isBadRequest());
		System.out.println("*** testGetVendorSummaryForNonExistingVendor end ****");

	}

	@Test
	public void testGetVendorDetails() throws Exception {
		mockMvc.perform(get("/vendors/1/details")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.name", is("Sai Mess")))
				.andExpect(jsonPath("$.owner.mobileNo", is("7276248187")));

	}

	@Test
	public void testGetVendorDetailsForNonExistingVendor() throws Exception {
		mockMvc.perform(get("/vendors/123456234/details")).andDo(print()).andExpect(status().isBadRequest());

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
				.andDo(print()).andExpect(status().isCreated());

		System.out.println("*** testCreateVendor end ****");

	}

	@Test
	public void testCreateVendorWithConstraintViolation() throws Exception {
		System.out.println("*** testCreateVendorWithConstraintViolation start  ****");
		VendorDTO vendor = VendorDTODataSample.getVendorDTO();

		vendor.setName("Sai9 Dhaba");
		vendor.getOwner().setEmailID(new EmailIDDTO("sai9@gmail.com"));

		mockMvc.perform(post("/vendors").contentType(contentType).content(TestUtils.convertObjectToJsonString(vendor)))
				.andDo(print()).andExpect(status().isBadRequest()).andExpect(jsonPath("$[0].fieldName", is("name")));

		System.out.println("*** testCreateVendorWithConstraintViolation end ****");

	}

	@Test
	public void testCreateVendorWithConstraintViolation2() throws Exception {
		System.out.println("*** testCreateVendorWithConstraintViolation2 start ****");
		VendorDTO vendor = VendorDTODataSample.getVendorDTO();

		vendor.getVendorAddress().setCountry("US");
		vendor.getOwner().setEmailID(new EmailIDDTO("sai9@gmail.com"));

		mockMvc.perform(post("/vendors").contentType(contentType).content(TestUtils.convertObjectToJsonString(vendor)))
				.andExpect(status().isBadRequest()).andDo(print())
				.andExpect(jsonPath("$[0].fieldName", is("vendorAddress")));

		System.out.println("*** testCreateVendorWithConstraintViolation2 end ****");

	}

	@Test
	public void testVendorDelete() throws Exception {
		mockMvc.perform(delete("/vendors/3")).andDo(print()).andExpect(status().isNoContent());

	}

	@Test
	public void testVendorDeleteWithNonExistingVendor() throws Exception {
		mockMvc.perform(delete("/vendors/12345675")).andDo(print()).andExpect(status().isBadRequest());

	}

	@Test
	public void testVendorUpdate() throws IOException, Exception {

		VendorDTO dto = VendorDTODataSample.getVendorDTO();
		dto.setId(1);
		dto.getOwner().setId(25); // trying to give wrong id of owner . It
									// should ignore this id

		mockMvc.perform(put("/vendors/2").contentType(contentType).content(TestUtils.convertObjectToJsonString(dto)))
				.andDo(print()).andExpect(status().isNoContent());

	}

	@Test
	public void testVendorUpdateWithInvalidData() throws IOException, Exception {

		VendorDTO dto = VendorDTODataSample.getVendorDTO();
		dto.setName("Andha 9");// trying to give wrong id of owner . It
								// should ignore this id

		mockMvc.perform(put("/vendors/2").contentType(contentType).content(TestUtils.convertObjectToJsonString(dto)))
				.andDo(print()).andExpect(status().isBadRequest()).andExpect(jsonPath("$[0].fieldName", is("name")));

	}

	@Test
	public void testVendorUpdateWithNonExistingVendor() throws IOException, Exception {
		VendorDTO dto = VendorDTODataSample.getVendorDTO();

		mockMvc.perform(
				put("/vendors/123456456").contentType(contentType).content(TestUtils.convertObjectToJsonString(dto)))
				.andDo(print()).andExpect(status().isBadRequest());

	}

	@Test
	public void getAllVendorsSummary() throws Exception {
		mockMvc.perform(get("/vendors/all")).andDo(print()).andExpect(status().isOk());
		System.out.println("*** testGetVendorSummary end ****");
	}

}
