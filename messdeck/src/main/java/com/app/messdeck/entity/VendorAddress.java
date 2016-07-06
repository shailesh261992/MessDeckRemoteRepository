package com.app.messdeck.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VendorAddress extends Address {

	@Override
	public String toString() {
		return "VendorAddress [id=" + id + ", Address = " + super.toString() + "]";
	}

}
