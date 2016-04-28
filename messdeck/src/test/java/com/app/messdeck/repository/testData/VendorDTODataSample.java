package com.app.messdeck.repository.testData;

import com.app.messdeck.entity.EmailID;
import com.app.messdeck.entity.Gender;
import com.app.messdeck.entity.Name;
import com.app.messdeck.entity.Owner;
import com.app.messdeck.entity.OwnerAddress;
import com.app.messdeck.entity.Vendor;
import com.app.messdeck.entity.VendorAddress;
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
		vendorAddress.setCountry("India");
		vendorAddress.setPinCode("410");

		OwnerDTO andhraMessOwner = new OwnerDTO();
		andhraMessOwner.setName(new Name("Nikunj", "Viramgama"));
		andhraMessOwner.setEmailID(new EmailID("Nikunj@gmail.com"));
		andhraMessOwner.setMobileNo("9876543210");
		OwnerAddressDTO ownerAddress = new OwnerAddressDTO();
		ownerAddress.setCity("Pimpari");
		andhraMessOwner.setOwnerAddress(ownerAddress);
		andhraMessOwner.setGender(Gender.MALE);

		andhraMess.setVendorAddress(vendorAddress);
		andhraMess.setOwner(andhraMessOwner);
		return andhraMess;
	}

}
