package com.app.messdeck.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Owner extends Person {
	@Id
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private OwnerAddress ownerAddress;

	public Owner() {
		this.ownerAddress = new OwnerAddress();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public OwnerAddress getOwnerAddress() {
		return ownerAddress;
	}

	public void setOwnerAddress(OwnerAddress ownerAddress) {
		this.ownerAddress = ownerAddress;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", ownerAddress=" + ownerAddress + ", person" + super.toString() + "]";
	}

	

}
