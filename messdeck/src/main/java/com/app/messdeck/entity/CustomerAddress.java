package com.app.messdeck.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerAddress extends Address {
//	@Id
//	private long id;

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
