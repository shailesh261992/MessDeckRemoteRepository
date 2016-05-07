package com.app.messdeck.utility;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.app.messdeck.entity.Vendor;
import com.app.messdeck.model.dto.VendorDTO;

public class EntityConverter {

	public static VendorDTO getVendorSummaryDTO(Vendor vendor) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<Vendor, VendorDTO>() {

			@Override
			protected void configure() {
				skip().setOwner(null);
				skip().setCustomers(null);
				skip().setServices(null);

			}
		});
		
		
		VendorDTO dto = modelMapper.map(vendor, VendorDTO.class);
		System.out.println("VendorSummary = " + dto);
		return dto;

	}
	
	
	public static VendorDTO getVendorDetailsDTO(Vendor vendor) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<Vendor, VendorDTO>() {

			@Override
			protected void configure() {
				skip().setCustomers(null);
				skip().setServices(null);

			}
		});
		
		
		VendorDTO dto = modelMapper.map(vendor, VendorDTO.class);
		System.out.println("VendorSummary = " + dto);
		return dto;

	}

}
