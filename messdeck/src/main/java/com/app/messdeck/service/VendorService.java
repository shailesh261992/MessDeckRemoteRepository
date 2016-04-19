package com.app.messdeck.service;

import com.app.messdeck.model.dto.VendorDTO;

public interface VendorService {

	VendorDTO getVendor(Long id);

	Long createVendor(VendorDTO vendorDTO);

	void updateVendor(VendorDTO dto);

	void deleteVendor(Long id);

}
