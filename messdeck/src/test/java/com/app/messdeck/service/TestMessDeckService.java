package com.app.messdeck.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.app.messdeck.businessException.MessDeckServiceNotExistException;
import com.app.messdeck.businessException.VendorNotExistException;
import com.app.messdeck.configuration.testenvconfig.UnitTestConfigurationForServices;
import com.app.messdeck.model.dto.MessDeckServiceDTO;
import com.app.messdeck.repository.MessDeckServiceDAO;
import com.app.messdeck.repository.VendorDAO;
import com.app.messdeck.testData.MessDeckServiceDTODataSample;
import com.app.messdeck.utility.DTOConverter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UnitTestConfigurationForServices.class })
@WebAppConfiguration
public class TestMessDeckService {

	@Autowired
	private MessDeckService service;

	@Autowired
	MessDeckServiceDAO daoMock;

	@Autowired
	VendorDAO vendorDaoMock;

	@Before
	public void setUp() throws Exception {
		Mockito.reset(daoMock);
	}

	@Test
	public void testCreate() {
		MessDeckServiceDTO messDeckServiceDTO = MessDeckServiceDTODataSample.getMessDeckServiceDTO();
		com.app.messdeck.entity.MessDeckService messDeckService = DTOConverter.getMessDeckService(messDeckServiceDTO);
		when(daoMock.create(messDeckService)).thenReturn(1l);
		Long id = service.createMessDeckService(messDeckServiceDTO);
		assertEquals(new Long(1), id);

	}

	@Test(expected = VendorNotExistException.class)
	public void tesCreateWithNonExistingVendor() {

		MessDeckServiceDTO messDeckServiceDTO = MessDeckServiceDTODataSample.getMessDeckServiceDTO();
		messDeckServiceDTO.setId(1);
		com.app.messdeck.entity.MessDeckService messDeckService = DTOConverter.getMessDeckService(messDeckServiceDTO);

		when(daoMock.create(messDeckService)).thenThrow(new VendorNotExistException(1));
		service.createMessDeckService(messDeckServiceDTO);

	}

	@Test
	public void testGetMessDeckService() {
		MessDeckServiceDTO messDeckServiceDTO = MessDeckServiceDTODataSample.getMessDeckServiceDTO();
		messDeckServiceDTO.setId(1);
		com.app.messdeck.entity.MessDeckService messDeckService = DTOConverter.getMessDeckService(messDeckServiceDTO);
		when(daoMock.get(1l)).thenReturn(messDeckService);

		messDeckServiceDTO.equals(service.getMessDeckService(1l));
		assertEquals(messDeckServiceDTO, service.getMessDeckService(1l));
	}

	@Test(expected = MessDeckServiceNotExistException.class)
	public void testGetForNonExistingMessDeckService() {
		when(daoMock.get(Long.MAX_VALUE)).thenThrow(new MessDeckServiceNotExistException(Long.MAX_VALUE));
		service.getMessDeckService(Long.MAX_VALUE);
	}

}
