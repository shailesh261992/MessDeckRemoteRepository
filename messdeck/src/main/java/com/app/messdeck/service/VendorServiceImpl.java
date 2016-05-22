package com.app.messdeck.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.messdeck.aspects.ValidateWithOval;
import com.app.messdeck.businessException.VendorNotExistException;
import com.app.messdeck.entity.Customer;
import com.app.messdeck.entity.Vendor;
import com.app.messdeck.model.dto.CustomerDTO;
import com.app.messdeck.model.dto.VendorDTO;
import com.app.messdeck.repository.VendorDAO;
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

		return EntityConverter.getVendorDetailsDTO(vendor);

	}

	@Override
	@ValidateWithOval
	public Long createVendor(VendorDTO vendorDTO) {
		System.out.println("*** dto = " + vendorDTO);
		Vendor vendor = DTOConverter.getVendor(vendorDTO);
		vendor.setRegistrationDate(LocalDateTime.now());
		System.out.println("*** vendor = " + vendor);
		return dao.create(vendor);

	}

	@Override
	@ValidateWithOval
	public void updateVendor(VendorDTO dto) {

		dao.update(DTOConverter.getVendor(dto));

	}

	@Override
	public void deleteVendor(Long id) {
		Vendor vendor = dao.get(id);
		if (vendor != null) {
			dao.delete(vendor);
		} else {
			throw new VendorNotExistException(id);
		}

	}

	@Override
	public List<VendorDTO> getAllVendorsSummary() {
		List<Vendor> vendors = dao.getAll();
		List<VendorDTO> dtoList = new ArrayList<>();
		if (vendors != null) {
			for (Vendor vendor : vendors) {
				dtoList.add(EntityConverter.getVendorSummaryDTO(vendor));
			}
			return dtoList;
		}

		return null;
	}

	@Override
	public List<CustomerDTO> getCustomrs(Long id) {
		Vendor vendor = dao.get(id);
		List<Customer> customers = vendor.getCustomers();
		List<CustomerDTO> customrsDto = new ArrayList<>();
		for (Customer c : customers) {
			customrsDto.add(EntityConverter.getCustomorSummaryDTO(c));
		}
		return customrsDto;
	}

}
