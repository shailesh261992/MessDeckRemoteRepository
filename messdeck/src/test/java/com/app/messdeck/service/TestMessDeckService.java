package com.app.messdeck.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.app.messdeck.businessException.MessDeckServiceInfoNotExistException;
import com.app.messdeck.businessException.ValidationException;
import com.app.messdeck.businessException.VendorNotExistException;
import com.app.messdeck.configuration.testenvconfig.UnitTestConfigurationForServices;
import com.app.messdeck.entity.MessDeckServiceInfo;
import com.app.messdeck.model.dto.MessDeckServiceInfoDTO;
import com.app.messdeck.repository.MessDeckServiceInfoDAO;
import com.app.messdeck.repository.VendorDAO;
import com.app.messdeck.test.data.MessDeckServiceInfoDTODataSample;
import com.app.messdeck.utility.DTOConverter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UnitTestConfigurationForServices.class })
@WebAppConfiguration
public class TestMessDeckService {

	@Autowired
	private MessDeckService service;

	@Autowired
	MessDeckServiceInfoDAO daoMock;

	@Autowired
	VendorDAO vendorDaoMock;

	@Before
	public void setUp() throws Exception {
		Mockito.reset(daoMock);
	}

	@Test
	public void testCreate() {
		MessDeckServiceInfoDTO messDeckServiceDTO = MessDeckServiceInfoDTODataSample.getMessDeckServiceInfoDTO();
		com.app.messdeck.entity.MessDeckServiceInfo messDeckService = DTOConverter
				.getMessDeckServiceInfo(messDeckServiceDTO);
		when(daoMock.create(messDeckService)).thenReturn(1l);
		Long id = service.createMessDeckService(messDeckServiceDTO);
		assertEquals(new Long(1), id);

	}

	@Test(expected = ValidationException.class)
	public void testCreateWithInvalidData() {
		MessDeckServiceInfoDTO messDeckServiceDTO = MessDeckServiceInfoDTODataSample.getMessDeckServiceInfoDTO();
		messDeckServiceDTO.setCost(-2);
		MessDeckServiceInfo messDeckService = DTOConverter.getMessDeckServiceInfo(messDeckServiceDTO);
		when(daoMock.create(messDeckService)).thenReturn(1l);
		service.createMessDeckService(messDeckServiceDTO);

	}

	@Test(expected = VendorNotExistException.class)
	public void tesCreateWithNonExistingVendor() {

		MessDeckServiceInfoDTO messDeckServiceDTO = MessDeckServiceInfoDTODataSample.getMessDeckServiceInfoDTO();
		messDeckServiceDTO.setId(1);
		com.app.messdeck.entity.MessDeckServiceInfo messDeckService = DTOConverter
				.getMessDeckServiceInfo(messDeckServiceDTO);

		when(daoMock.create(messDeckService)).thenThrow(new VendorNotExistException(1));
		service.createMessDeckService(messDeckServiceDTO);

	}

	@Test
	public void testGetMessDeckService() {
		MessDeckServiceInfoDTO messDeckServiceDTO = MessDeckServiceInfoDTODataSample.getMessDeckServiceInfoDTO();
		messDeckServiceDTO.setId(1);
		com.app.messdeck.entity.MessDeckServiceInfo messDeckService = DTOConverter
				.getMessDeckServiceInfo(messDeckServiceDTO);
		when(daoMock.get(1l)).thenReturn(messDeckService);

		messDeckServiceDTO.equals(service.getMessDeckService(1l));
		assertEquals(messDeckServiceDTO, service.getMessDeckService(1l));
	}

	@Test(expected = MessDeckServiceInfoNotExistException.class)
	public void testGetForNonExistingMessDeckService() {
		when(daoMock.get(Long.MAX_VALUE)).thenThrow(new MessDeckServiceInfoNotExistException(Long.MAX_VALUE));
		service.getMessDeckService(Long.MAX_VALUE);
	}

	@Test
	public void testDelete() {
		doNothing().when(daoMock).delete(1l);
		service.deleteMessDeckService(1l);
		verify(daoMock).delete(1l);

	}

	@Test(expected = MessDeckServiceInfoNotExistException.class)
	public void testDeleteForNonExistingService() {
		doThrow(MessDeckServiceInfoNotExistException.class).when(daoMock).delete(Long.MAX_VALUE);
		service.deleteMessDeckService(Long.MAX_VALUE);
	}

	@Test
	public void testUpdate() {
		MessDeckServiceInfoDTO messDeckServiceDTO = MessDeckServiceInfoDTODataSample.getMessDeckServiceInfoDTO();

		MessDeckServiceInfoDTO updatedMessDeckServiceDTO = MessDeckServiceInfoDTODataSample.getMessDeckServiceInfoDTO();
		updatedMessDeckServiceDTO.setCost(244);
		when(daoMock.get(1l)).thenReturn(DTOConverter.getMessDeckServiceInfo(messDeckServiceDTO))
				.thenReturn(DTOConverter.getMessDeckServiceInfo(updatedMessDeckServiceDTO));
		service.getMessDeckService(1l);
		service.updateMessDeckService(updatedMessDeckServiceDTO);
		MessDeckServiceInfoDTO updatedMessDeckService = service.getMessDeckService(1l);
		assertEquals(updatedMessDeckService, service.getMessDeckService(1l));

	}

	@Test(expected = MessDeckServiceInfoNotExistException.class)
	@Transactional
	public void testUpdateNonExistingMessDeckService() {
		doThrow(MessDeckServiceInfoNotExistException.class).when(daoMock).update(any(MessDeckServiceInfo.class));
		MessDeckServiceInfoDTO messDeckServiceInfoDTO = MessDeckServiceInfoDTODataSample.getMessDeckServiceInfoDTO();
		service.updateMessDeckService(messDeckServiceInfoDTO);
	}

}
