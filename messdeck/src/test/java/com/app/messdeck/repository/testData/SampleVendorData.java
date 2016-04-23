package com.app.messdeck.repository.testData;

import java.util.ArrayList;

import com.app.messdeck.entity.EmailID;
import com.app.messdeck.entity.Gender;
import com.app.messdeck.entity.Name;
import com.app.messdeck.entity.Owner;
import com.app.messdeck.entity.OwnerAddress;
import com.app.messdeck.entity.Vendor;
import com.app.messdeck.entity.VendorAddress;

public class SampleVendorData {

	public static Vendor getVendorOne() {

		Vendor saiMess = new Vendor();
		saiMess.setName("Sai Mess");
		saiMess.setVendorAddress(createVendorAddress(saiMess));
		saiMess.setOwner(createOwnerOne(saiMess));

		return saiMess;

	}

	private static VendorAddress createVendorAddress(Vendor saiMess) {
		VendorAddress vendorAddress = new VendorAddress();
		vendorAddress.setCity("pune");
		vendorAddress.setCountry("India");
		vendorAddress.setPinCode("410");
		return vendorAddress;
	}

	private static Owner createOwnerOne(Vendor saiMess) {
		Owner saiMessOwner = new Owner();
		saiMessOwner.setName(new Name("Shailesh", "Kadam"));
		saiMessOwner.setEmailID(new EmailID("shailesh261992@gmail.com"));
		saiMessOwner.setMobileNo("7276248187");
		saiMessOwner.setGender(Gender.MALE);
		saiMessOwner.setOwnerAddress(createOwnerAddressOne(saiMessOwner));
		return saiMessOwner;
	}

	private static OwnerAddress createOwnerAddressOne(Owner saiMessOwner) {
		OwnerAddress ownerAddress = new OwnerAddress();
		ownerAddress.setCity("Talegaon");

		return ownerAddress;
	}

	public static Vendor getVendorTwo() {

		Vendor andhraMess = new Vendor();
		andhraMess.setName("Andhra Mess");
		VendorAddress vendorAddress = new VendorAddress();
		vendorAddress.setCity("pune");
		vendorAddress.setCountry("India");
		vendorAddress.setPinCode("410");

		Owner andhraMessOwner = new Owner();
		andhraMessOwner.setName(new Name("Nikunj", "Viramgama"));
		andhraMessOwner.setEmailID(new EmailID("Nikunj@gmail.com"));
		andhraMessOwner.setMobileNo("9876543210");
		OwnerAddress ownerAddress = new OwnerAddress();
		ownerAddress.setCity("Pimpari");
		andhraMessOwner.setOwnerAddress(ownerAddress);
		andhraMessOwner.setGender(Gender.MALE);

		andhraMess.setVendorAddress(vendorAddress);
		andhraMess.setOwner(andhraMessOwner);
		return andhraMess;

	}

	public static Vendor getVendorThree() {

		Vendor santoshMess = new Vendor();
		santoshMess.setName("Santosh Mess");
		VendorAddress vendorAddress = new VendorAddress();
		vendorAddress.setCity("pune");
		vendorAddress.setCountry("India");
		vendorAddress.setPinCode("410");

		Owner andhraMessOwner = new Owner();
		andhraMessOwner.setName(new Name("Tushar", "Bandal"));
		andhraMessOwner.setEmailID(new EmailID("tushar@gmail.com"));
		andhraMessOwner.setMobileNo("7876643210");
		OwnerAddress ownerAddress = new OwnerAddress();
		ownerAddress.setCity("Nal stop");
		andhraMessOwner.setOwnerAddress(ownerAddress);
		andhraMessOwner.setGender(Gender.MALE);

		santoshMess.setVendorAddress(vendorAddress);
		santoshMess.setOwner(andhraMessOwner);
		return santoshMess;

	}

	public static Vendor getVendorList() {
		ArrayList<Vendor> list = new ArrayList<>();
		list.add(getVendorOne());
		list.add(getVendorTwo());
		list.add(getVendorThree());
		return null;

	}

}
