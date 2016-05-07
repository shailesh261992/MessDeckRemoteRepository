package com.app.messdeck.model.dto;

import net.sf.oval.constraint.AssertValid;

public class OwnerDTO extends PersonDTO {

	private long id;

	@AssertValid
	private OwnerAddressDTO ownerAddress;

	public OwnerDTO() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public OwnerAddressDTO getOwnerAddress() {
		return ownerAddress;
	}

	public void setOwnerAddress(OwnerAddressDTO ownerAddress) {
		this.ownerAddress = ownerAddress;
	}

	@Override
	public String toString() {
		return "OwnerDTO [id=" + id + ", ownerAddress=" + ownerAddress + ", paerson = " + super.toString() + "]";
	}

}
