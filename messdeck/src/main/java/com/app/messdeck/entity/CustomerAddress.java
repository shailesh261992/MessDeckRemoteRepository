package com.app.messdeck.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerAddress extends Address {

	private long id;

	@Id
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
