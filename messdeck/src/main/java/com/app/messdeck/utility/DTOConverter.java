package com.app.messdeck.utility;

import com.app.messdeck.entity.Customer;
import com.app.messdeck.entity.Vendor;
import com.app.messdeck.model.dto.CustomerDTO;
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

	public static Customer DTOToEntityCoverter(CustomerDTO dto) {
		Customer customer = new Customer();
		customer.setId(dto.getId());
		customer.setAddress(dto.getAddress());
		customer.setEmailID(dto.getEmailID());
		customer.setGender(dto.getGender());
		customer.setMobileNo(dto.getMobileNo());
		customer.setName(dto.getName());
		Vendor vendor = new Vendor();
		vendor.setId(dto.getVendorID());
		customer.setVendor(vendor);

		return customer;

	}

	public static CustomerDTO EntityToDTOConverter(Customer customer) {
		CustomerDTO dto = new CustomerDTO();
		dto.setAddress(customer.getAddress());
		dto.setEmailID(customer.getEmailID());
		dto.setGender(customer.getGender());
		dto.setMobileNo(customer.getMobileNo());
		dto.setName(customer.getName());
		dto.setVendorID(customer.getVendor().getId());
		dto.setId(customer.getId());
		return dto;

	}

}
