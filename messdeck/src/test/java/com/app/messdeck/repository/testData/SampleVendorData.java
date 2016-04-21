package com.app.messdeck.repository.testData;

import java.util.ArrayList;

import com.app.messdeck.entity.Address;
import com.app.messdeck.entity.EmailID;
import com.app.messdeck.entity.Gender;
import com.app.messdeck.entity.Name;
import com.app.messdeck.entity.Owner;
import com.app.messdeck.entity.Vendor;

public class SampleVendorData {

	public static Vendor getVendorOne() {

		Vendor saiMess = new Vendor();
		saiMess.setName("Sai Mess");
		Address vendorAddress = new Address();
		vendorAddress.setCity("pune");
		vendorAddress.setCountry("India");
		vendorAddress.setPinCode("410");

		Owner saiMessOwner = new Owner();
		saiMessOwner.setName(new Name("Shailesh", "Kadam"));
		saiMessOwner.setEmailID(new EmailID("shailesh261992@gmail.com"));
		saiMessOwner.setMobileNo("7276248187");
		Address ownerAddress = new Address();
		ownerAddress.setCity("Talegaon");
		saiMessOwner.setAddress(ownerAddress);
		saiMessOwner.setGender(Gender.MALE);

		saiMess.setVendorddress(vendorAddress);
		saiMess.setOwner(saiMessOwner);
		return saiMess;

	}

	public static Vendor getVendorTwo() {

		Vendor andhraMess = new Vendor();
		andhraMess.setName("Andhra Mess");
		Address vendorAddress = new Address();
		vendorAddress.setCity("pune");
		vendorAddress.setCountry("India");
		vendorAddress.setPinCode("410");

		Owner andhraMessOwner = new Owner();
		andhraMessOwner.setName(new Name("Nikunj", "Viramgama"));
		andhraMessOwner.setEmailID(new EmailID("Nikunj@gmail.com"));
		andhraMessOwner.setMobileNo("9876543210");
		Address ownerAddress = new Address();
		ownerAddress.setCity("Pimpari");
		andhraMessOwner.setAddress(ownerAddress);
		andhraMessOwner.setGender(Gender.MALE);

		andhraMess.setVendorddress(vendorAddress);
		andhraMess.setOwner(andhraMessOwner);
		return andhraMess;

	}

	public static Vendor getVendorThree() {

		Vendor santoshMess = new Vendor();
		santoshMess.setName("Santosh Mess");
		Address vendorAddress = new Address();
		vendorAddress.setCity("pune");
		vendorAddress.setCountry("India");
		vendorAddress.setPinCode("410");

		Owner andhraMessOwner = new Owner();
		andhraMessOwner.setName(new Name("Tushar", "Bandal"));
		andhraMessOwner.setEmailID(new EmailID("tushar@gmail.com"));
		andhraMessOwner.setMobileNo("7876643210");
		Address ownerAddress = new Address();
		ownerAddress.setCity("Nal stop");
		andhraMessOwner.setAddress(ownerAddress);
		andhraMessOwner.setGender(Gender.MALE);

		santoshMess.setVendorddress(vendorAddress);
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
