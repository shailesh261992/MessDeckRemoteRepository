package com.app.messdeck.model.dto;

import javax.persistence.Id;

public class CustomerAddressDTO extends AddressDTO {

	@Override
	public String toString() {
		return "CustomerAddress [id=" + id + ", address=" + super.toString() + "]";
	}
}
