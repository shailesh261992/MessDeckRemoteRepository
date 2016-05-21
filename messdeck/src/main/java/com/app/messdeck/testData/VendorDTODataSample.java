package com.app.messdeck.testData;

import java.util.ArrayList;

import com.app.messdeck.entity.Gender;
import com.app.messdeck.model.dto.CustomerDTO;
import com.app.messdeck.model.dto.EmailIDDTO;
import com.app.messdeck.model.dto.MessDeckServiceDTO;
import com.app.messdeck.model.dto.NameDTO;
import com.app.messdeck.model.dto.OwnerAddressDTO;
import com.app.messdeck.model.dto.OwnerDTO;
import com.app.messdeck.model.dto.VendorAddressDTO;
import com.app.messdeck.model.dto.VendorDTO;

public class VendorDTODataSample {

	public static VendorDTO getVendorDTO() {
		VendorDTO andhraMess = new VendorDTO();
		andhraMess.setName("Andhra Mess");

		VendorAddressDTO vendorAddress = new VendorAddressDTO();
		vendorAddress.setCity("pune");
		vendorAddress.setState("Maharashtra");
		vendorAddress.setCountry("India");
		vendorAddress.setPinCode("410507");

		OwnerDTO andhraMessOwner = new OwnerDTO();
		andhraMessOwner.setName(new NameDTO("Nikunj", "Viramgama"));
		andhraMessOwner.setEmailID(new EmailIDDTO("Nikunj@gmail.com"));
		andhraMessOwner.setMobileNo("9876543210");
		OwnerAddressDTO ownerAddress = new OwnerAddressDTO();
		ownerAddress.setCity("pune");
		ownerAddress.setState("Maharashtra");
		ownerAddress.setCountry("India");
		ownerAddress.setPinCode("410507");
		andhraMessOwner.setOwnerAddress(ownerAddress);
		andhraMessOwner.setGender(Gender.MALE);

		andhraMess.setVendorAddress(vendorAddress);
		andhraMess.setOwner(andhraMessOwner);

		andhraMess.setCustomers(new ArrayList<CustomerDTO>());
		andhraMess.setServices(new ArrayList<MessDeckServiceDTO>());
		andhraMess.setEmailID(new EmailIDDTO("andhra@gmail.com"));

		return andhraMess;
	}

	// public static Vendor getEquivalentVendor() {
	// Vendor andhraMess = new Vendor();
	// andhraMess.setName("Andhra Mess");
	//
	// VendorAddress vendorAddress = new VendorAddress();
	// vendorAddress.setCity("pune");
	// vendorAddress.setState("Maharashtra");
	// vendorAddress.setCountry("India");
	// vendorAddress.setPinCode("410507");
	//
	// Owner andhraMessOwner = new Owner();
	// andhraMessOwner.setName(new Name("Nikunj", "Viramgama"));
	// andhraMessOwner.setEmailID(new EmailID("Nikunj@gmail.com"));
	// andhraMessOwner.setMobileNo("9876543210");
	// OwnerAddress ownerAddress = new OwnerAddress();
	// ownerAddress.setCity("pune");
	// ownerAddress.setState("Maharashtra");
	// ownerAddress.setCountry("India");
	// ownerAddress.setPinCode("410507");
	// andhraMessOwner.setOwnerAddress(ownerAddress);
	// andhraMessOwner.setGender(Gender.MALE);
	//
	// andhraMess.setVendorAddress(vendorAddress);
	// andhraMess.setOwner(andhraMessOwner);
	//
	// andhraMess.setCustomers(new ArrayList<Customer>());
	// andhraMess.setServices(new ArrayList<MessDeckService>());
	// return andhraMess;
	//
	// }

}
