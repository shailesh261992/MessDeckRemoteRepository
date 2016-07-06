package com.app.messdeck.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.messdeck.aspects.ValidateWithOval;
import com.app.messdeck.businessException.MessDeckServiceInfoNotExistException;
import com.app.messdeck.businessException.VendorNotExistException;
import com.app.messdeck.entity.MessDeckServiceInfo;
import com.app.messdeck.model.dto.MessDeckServiceInfoDTO;
import com.app.messdeck.modelmapper.DTOConverter;
import com.app.messdeck.modelmapper.EntityConverter;
import com.app.messdeck.repository.MessDeckServiceInfoDAO;
import com.app.messdeck.repository.MessDeckServiceInfoRepository;
import com.app.messdeck.repository.VendorDAO;
import com.app.messdeck.repository.VendorRepository;

@Service
@Transactional
public class MessDeckServiceImpl implements MessDeckService {

	// @Autowired
	// MessDeckServiceInfoDAO messDeckServiceDAO;
	//
	// @Autowired
	// VendorDAO vendorDAO;

	@Autowired
	private MessDeckServiceInfoRepository repository;

	@Autowired
	private VendorRepository vendorRepository;

	@Override
	@ValidateWithOval
	public Long createMessDeckService(MessDeckServiceInfoDTO messDeckServiceDTO) {
		MessDeckServiceInfo messDeckServiceInfo;
		if (vendorRepository.exists(messDeckServiceDTO.getVendorId())) {
			messDeckServiceInfo = repository.save(DTOConverter.getMessDeckServiceInfo(messDeckServiceDTO));
			return messDeckServiceInfo.getId();
		} else {
			throw new VendorNotExistException(messDeckServiceDTO.getVendorId());
		}

	}

	@Override
	public MessDeckServiceInfoDTO getMessDeckService(Long id) {
		Optional<MessDeckServiceInfo> messDeckServiceInfo = Optional.ofNullable(repository.findOne(id));
		if (messDeckServiceInfo.isPresent()) {
			return EntityConverter.getMessDeckServiceInfoDTO(messDeckServiceInfo.get());

		} else {
			throw new MessDeckServiceInfoNotExistException(id);
		}

	}

	@Override
	@ValidateWithOval
	public void updateMessDeckService(MessDeckServiceInfoDTO messDeckServiceDTO) {
		if (repository.exists(messDeckServiceDTO.getId())) {
			MessDeckServiceInfo messDeckServiceInfo = repository.getOne(messDeckServiceDTO.getId());
			if (messDeckServiceDTO.getVendorId() == messDeckServiceInfo.getVendor().getId()) {
				repository.save(DTOConverter.getMessDeckServiceInfo(messDeckServiceDTO));
			} else {
				throw new RuntimeException("Not allowed to update vendor of service vendor should be with id = "
						+ messDeckServiceInfo.getVendor().getId());
			}
		}

	}

	@Override
	public void deleteMessDeckService(Long id) {
		if (repository.exists(id)) {
			repository.delete(id);
		} else {
			throw new MessDeckServiceInfoNotExistException(id);
		}

	}

}
