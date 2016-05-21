package com.app.messdeck.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.messdeck.model.dto.MessDeckServiceInfoDTO;
import com.app.messdeck.repository.MessDeckServiceInfoDAO;
import com.app.messdeck.repository.VendorDAO;
import com.app.messdeck.utility.DTOConverter;
import com.app.messdeck.utility.EntityConverter;

@Service
@Transactional
public class MessDeckServiceImpl implements MessDeckService {

	@Autowired
	MessDeckServiceInfoDAO messDeckServiceDAO;

	@Autowired
	VendorDAO vendorDAO;

	@Override
	public Long createMessDeckService(MessDeckServiceInfoDTO messDeckServiceDTO) {
		return messDeckServiceDAO.create(DTOConverter.getMessDeckServiceInfo(messDeckServiceDTO));

	}

	@Override
	public MessDeckServiceInfoDTO getMessDeckService(Long id) {
		return EntityConverter.getMessDeckServiceInfoDTO(messDeckServiceDAO.get(id));
	}

	@Override
	public void updateMessDeckService(MessDeckServiceInfoDTO messDeckServiceDTO) {

		messDeckServiceDAO.update(DTOConverter.getMessDeckServiceInfo(messDeckServiceDTO));
	}

	@Override
	public void deleteMessDeckService(Long id) {
		messDeckServiceDAO.delete(id);

	}

}
