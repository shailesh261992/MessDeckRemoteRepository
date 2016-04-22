package com.app.messdeck.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Owner extends Person {
	@Id
	@GeneratedValue(generator = "foreigngen")
	@GenericGenerator(strategy = "foreign", name = "foreigngen", parameters = @Parameter(name = "property", value = "vendor") )
	@Column(name = "id")
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private OwnerAddress ownerAddress;

	@OneToOne(mappedBy = "owner")
	private Vendor vendor;

	public Owner() {
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

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", ownerAddress=" + ownerAddress + "]";
	}

}
