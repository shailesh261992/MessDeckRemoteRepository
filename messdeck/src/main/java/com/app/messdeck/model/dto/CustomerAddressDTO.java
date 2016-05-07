package com.app.messdeck.model.dto;

import javax.persistence.Id;

public class CustomerAddressDTO extends AddressDTO {
	private long id;

	@Id
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CustomerAddress [id=" + id + ", address=" + super.toString() + "]";
	}
}
