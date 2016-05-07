package com.app.messdeck.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Customer extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private CustomerAddress customerAddress;

	@ManyToOne
	@JoinColumn(name = "vendorID", nullable = false)
	private Vendor vendor;

	@ManyToMany
	@JoinTable(name = "CustomerService")
	private List<MessDeckService> subscribedServices;

	public Customer() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public CustomerAddress getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(CustomerAddress customerAddress) {
		this.customerAddress = customerAddress;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerAddress=" + customerAddress + ", vendor=" + vendor + ", person="
				+ super.toString() + "]";
	}

}
