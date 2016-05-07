package com.app.messdeck.model.dto;

public class CustomerDTO extends PersonDTO {

	private long vendorID;

	public CustomerDTO() {
	}

	public long getVendorID() {
		return vendorID;
	}

	public void setVendorID(long vendorID) {
		this.vendorID = vendorID;
	}

}
