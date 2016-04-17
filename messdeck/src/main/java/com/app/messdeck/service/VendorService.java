package com.app.messdeck.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.messdeck.model.dto.VendorDTO;
import com.app.messdeck.repository.VenderDAO;
import com.app.messdeck.utility.DTOConverter;

@Service
@Transactional
public class VendorService {
	@Autowired
	private VenderDAO dao;

	public VendorDTO getVendor(Long id) {
		return DTOConverter.EntityToDTOConverter(dao.read(id));
	}

	public Long createVendor(VendorDTO vendorDTO) {
		return dao.create(DTOConverter.DTOToEntityCoverter(vendorDTO));
	}

	public void updateVendor(VendorDTO dto) {
		dao.update(DTOConverter.DTOToEntityCoverter(dto));

	}

	public void deleteVendor(Long id) {
		dao.delete(dao.read(id));
	}

}
