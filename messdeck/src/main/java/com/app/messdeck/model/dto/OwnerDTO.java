package com.app.messdeck.model.dto;

public class OwnerDTO extends PersonDTO {

	private long id;

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
		return "Owner [id=" + id + ", ownerAddress=" + ownerAddress + "]";
	}
}
