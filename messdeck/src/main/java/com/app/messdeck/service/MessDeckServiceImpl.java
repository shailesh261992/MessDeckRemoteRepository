package com.app.messdeck.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.messdeck.model.dto.MessDeckServiceDTO;
import com.app.messdeck.repository.MessDeckServiceDAO;
import com.app.messdeck.repository.VendorDAO;
import com.app.messdeck.utility.DTOConverter;
import com.app.messdeck.utility.EntityConverter;

@Service
@Transactional
public class MessDeckServiceImpl implements MessDeckService {

	@Autowired
	MessDeckServiceDAO messDeckServiceDAO;

	@Autowired
	VendorDAO vendorDAO;

	@Override
	public Long createMessDeckService(MessDeckServiceDTO messDeckServiceDTO) {
		return messDeckServiceDAO.create(DTOConverter.getMessDeckService(messDeckServiceDTO));

	}

	@Override
	public MessDeckServiceDTO getMessDeckService(Long id) {
		return EntityConverter.getMessDeckServiceDTO(messDeckServiceDAO.get(id));
	}

	@Override
	public void updateMessDeckService(MessDeckServiceDTO messDeckServiceDTO) {

		//com.app.messdeck.entity.MessDeckService messDeckService = DTOConverter.getMessDeckService(messDeckServiceDTO);

//		Vendor v = vendorDAO.get(messDeckServiceDTO.getVendor().getId());
//		// Vendor vendor = new Vendor();
//		// vendor.setId(messDeckServiceDTO.getVendorId());
//		// messDeckService.setVendor(messDeckServiceDTO.getVendor());
//
//		messDeckServiceDAO.update(messDeckService);

	}

	@Override
	public void deleteMessDeckService(Long id) {
		// messDeckServiceDAO.delete(messDeckServiceDAO.getMessDeckService(id));

		messDeckServiceDAO.delete(id);

	}

}
