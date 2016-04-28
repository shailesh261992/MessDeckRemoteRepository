package com.app.messdeck.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.messdeck.entity.Vendor;
import com.app.messdeck.model.dto.MessDeckServiceDTO;
import com.app.messdeck.repository.MessDeckServiceDAO;
import com.app.messdeck.repository.VendorDAO;
import com.app.messdeck.utility.DTOConverter;

@Service
@Transactional
public class MessDeckServiceImpl implements MessDeckService {

	@Autowired
	MessDeckServiceDAO messDeckServiceDAO;

	@Autowired
	VendorDAO vendorDAO;

	@Override
	public Long saveMessDeckService(MessDeckServiceDTO messDeckServiceDTO) {
		// TODO Auto-generated method stub

		System.out.println("***DTO=" + messDeckServiceDTO);
		return messDeckServiceDAO
				.saveMessDeckService(DTOConverter.dtoTOEntityCoverterForMessDeckService(messDeckServiceDTO));

	}

	@Override
	public MessDeckServiceDTO getMessDeckService(Long id) {
		return DTOConverter.entityTODTOCoverterForMessDeckService(messDeckServiceDAO.getMessDeckService(id));
	}

	@Override
	public void updateMessDeckService(MessDeckServiceDTO messDeckServiceDTO) {

		com.app.messdeck.entity.MessDeckService messDeckService = DTOConverter
				.dtoTOEntityCoverterForMessDeckService(messDeckServiceDTO);

		Vendor v = vendorDAO.read(messDeckServiceDTO.getVendorId());
		Vendor vendor = new Vendor();
		vendor.setId(messDeckServiceDTO.getVendorId());
		messDeckService.setVendor(vendor);

		messDeckServiceDAO.update(messDeckService);

	}

	@Override
	public void deleteMessDeckService(Long id) {
		// messDeckServiceDAO.delete(messDeckServiceDAO.getMessDeckService(id));

		messDeckServiceDAO.delete(messDeckServiceDAO.getMessDeckService(id));

	}

}
