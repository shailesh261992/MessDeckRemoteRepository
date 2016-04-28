package com.app.messdeck.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.messdeck.model.dto.VendorDTO;
import com.app.messdeck.repository.VendorDAO;
import com.app.messdeck.utility.DTOConverter;

@Service
@Transactional
public class VendorServiceImpl implements VendorService {
	@Autowired
	private VendorDAO dao;

	@Override
	public VendorDTO getVendor(Long id) {
		return DTOConverter.entityToDTOConverter(dao.read(id));
	}

	@Override
	@ValidateWithOval
	public Long createVendor(VendorDTO vendorDTO) {
		return dao.create(DTOConverter.dTOToEntityCoverter(vendorDTO));
	}

	@Override
	public void updateVendor(VendorDTO dto) {
		dao.update(DTOConverter.dTOToEntityCoverter(dto));

	}

	@Override
	public void deleteVendor(Long id) {
		dao.delete(dao.read(id));
	}

}
