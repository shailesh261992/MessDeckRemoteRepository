package com.app.messdeck.service;

import com.app.messdeck.businessException.VendorNotExistException;
import com.app.messdeck.model.dto.VendorDTO;

public interface VendorService {

	VendorDTO getVendorSummary(Long id) throws VendorNotExistException;

	VendorDTO getVendorDetails(Long id) throws VendorNotExistException;

	Long createVendor(VendorDTO vendorDTO);

	void updateVendor(VendorDTO dto);

	void deleteVendor(Long id);

}
