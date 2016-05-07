package com.app.messdeck.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Customer extends Person {

	@Id
	private long id;

	@ManyToOne
	@JoinColumn(name = "vendorID", nullable = false)
	private Vendor vendor;

	@ManyToMany
	@JoinTable(name = "CustomerService")
	private List<MessDeckService> subscribedServices;

	public Customer() {
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public List<MessDeckService> getSubscribedServices() {
		return subscribedServices;
	}

	public void setSubscribedServices(List<MessDeckService> subscribedServices) {
		this.subscribedServices = subscribedServices;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
