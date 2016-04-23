package com.app.messdeck.service;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.messdeck.businessException.VendorNotExistException;
import com.app.messdeck.entity.Vendor;
import com.app.messdeck.model.dto.VendorDTO;
import com.app.messdeck.repository.VendorDAO;
import com.app.messdeck.utility.DTOConverter;

@Service
@Transactional
public class VendorServiceImpl implements VendorService {
	@Autowired
	private VendorDAO dao;

	public VendorDTO getVendorSummary(Long id) throws VendorNotExistException {
		Vendor vendor = dao.get(id);
		if (vendor != null) {
			VendorDTO dto = new VendorDTO();
			BeanUtils.copyProperties(vendor, dto, "customers", "services", "owner");
			return dto;
		} else {
			throw new VendorNotExistException(id);
		}
	}

	@Override
	public VendorDTO getVendorDetails(Long id) throws VendorNotExistException {
		Vendor vendor = dao.get(id);
		if (vendor != null) {
			VendorDTO dto = new VendorDTO();
			BeanUtils.copyProperties(vendor, dto, "customers", "services");
			return dto;
		} else {
			throw new VendorNotExistException(id);
		}

	}

	public Long createVendor(VendorDTO vendorDTO) {
		Vendor vendor = new Vendor();
		BeanUtils.copyProperties(vendorDTO, vendor);
		System.out.println("*** dto = " + vendorDTO);
		System.out.println("*** vendor = " + vendor);
		return dao.create(vendor);
	}

	public void updateVendor(VendorDTO dto) {
		dao.update(DTOConverter.DTOToEntityCoverter(dto));

	}

	public void deleteVendor(Long id) {
		dao.delete(dao.get(id));
	}

}
