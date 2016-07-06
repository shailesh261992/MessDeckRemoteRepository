package com.app.messdeck.controller;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;

import com.app.messdeck.abstracttest.AbstractIntegrationTest;
import com.app.messdeck.businessException.MessDeckServiceInfoNotExistException;
import com.app.messdeck.model.dto.MessDeckServiceInfoDTO;
import com.app.messdeck.model.dto.VendorDTO;
import com.app.messdeck.test.data.MessDeckServiceInfoDataSample;
import com.app.messdeck.test.utils.TestUtils;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@DatabaseSetup(value = { "/dbunit/testdata/MessDeckServiceInfo.xml" })
public class MessDeckServiceControllerIntegrationTest extends AbstractIntegrationTest {

	@Test
	public void test() {
		// fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testGetMessDeckService() throws Exception {

		mockMvc.perform(get("/messdeckservice/1").accept(contentType)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.capacityOfMembers", is(46)));
	}

	@Test
	@Ignore
	public void testNonExistingGetMessDeckService() throws Exception {

		mockMvc.perform(get("/messdeckservice/" + Long.MAX_VALUE).accept(contentType)).andDo(print())
				.andExpect(status().isBadRequest());

	}

	@Test
	public void testCreateMessDeckService() throws Exception {
		MessDeckServiceInfoDTO messDeckServiceInfoDTO = MessDeckServiceInfoDataSample.getMessDeckServiceInfoDTO();
		VendorDTO vendorDTO = new VendorDTO();
		vendorDTO.setId(1l);
		messDeckServiceInfoDTO.setVendor(1);

		mockMvc.perform(post("/messdeckservice/").contentType(contentType).accept(contentType)
				.content(TestUtils.convertObjectToJsonString(messDeckServiceInfoDTO))).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", is(4)));
	}

}
