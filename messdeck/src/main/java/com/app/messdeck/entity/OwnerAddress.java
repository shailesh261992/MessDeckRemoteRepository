package com.app.messdeck.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OwnerAddress extends Address {

	@Override
	public String toString() {
		return "OwnerAddress [id=" + id + ", Address=" + super.toString() + "]";
	}

}
