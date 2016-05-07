package com.app.messdeck.service;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.messdeck.businessException.VendorNotExistException;
import com.app.messdeck.entity.Vendor;
import com.app.messdeck.model.dto.VendorAddressDTO;
import com.app.messdeck.model.dto.VendorDTO;
import com.app.messdeck.repository.VendorDAO;
import com.app.messdeck.testData.VendorDTODataSample;
import com.app.messdeck.utility.DTOConverter;
import com.app.messdeck.utility.EntityConverter;

@Service
@Transactional
public class VendorServiceImpl implements VendorService {
	@Autowired
	private VendorDAO dao;

	public VendorDTO getVendorSummary(Long id) throws VendorNotExistException {
		Vendor vendor = dao.get(id);
		if (vendor != null) {
			return EntityConverter.getVendorSummaryDTO(vendor);
		} else {
			throw new VendorNotExistException(id);
		}
	}

	@Override
	public VendorDTO getVendorDetails(Long id) throws VendorNotExistException {
		Vendor vendor = dao.get(id);
		if (vendor != null) {
			return EntityConverter.getVendorDetailsDTO(vendor);
		} else {
			throw new VendorNotExistException(id);
		}
	}

	@Override
	@ValidateWithOval
	public Long createVendor(VendorDTO vendorDTO) {
		System.out.println("*** dto = " + vendorDTO);
		System.out.println("*** vendor = " + DTOConverter.getVendor(vendorDTO));
		return dao.create(DTOConverter.getVendor(vendorDTO));

	}

	@Override
	public void updateVendor(VendorDTO dto) {
		dao.update(DTOConverter.dTOToEntityCoverter(dto));

	}

	@Override
	public void deleteVendor(Long id) {
		dao.delete(dao.get(id));
	}

}
