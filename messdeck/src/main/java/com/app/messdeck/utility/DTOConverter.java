package com.app.messdeck.utility;

import com.app.messdeck.entity.Vendor;
import com.app.messdeck.model.dto.VendorDTO;

public class DTOConverter {

	public static Vendor DTOToEntityCoverter(VendorDTO dto) {

		Vendor vendor = null;
		if (dto != null) {
			vendor = new Vendor();
			vendor.setId(dto.getId());
			vendor.setName(dto.getName());
			vendor.setOwner(dto.getOwner());
			vendor.setVendorddress(dto.getVendorddress());
		}

		return vendor;

	}

	public static VendorDTO EntityToDTOConverter(Vendor vendor) {
		VendorDTO vendorDTO = null;
		if (vendor != null) {
			vendorDTO = new VendorDTO();

			vendorDTO.setId(vendor.getId());
			vendorDTO.setName(vendor.getName());
			vendorDTO.setVendorddress(vendor.getVendorddress());
			vendorDTO.setOwner(vendor.getOwner());

		}

		return vendorDTO;

	}

}
