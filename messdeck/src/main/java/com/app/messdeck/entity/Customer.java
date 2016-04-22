package com.app.messdeck.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private VendorAddress vendorAddress;

	@ManyToOne
	@JoinColumn(name = "vendorID", nullable = false)
	private Vendor vendor;

	private double balanceAmount;
	private double creditAmount;

	@ManyToMany
	@JoinTable(name = "CustomerService")
	private List<MessDeckService> subscribedServices;

	public Customer() {
	}

	public double getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(double creditAmount) {
		this.creditAmount = creditAmount;
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

	public VendorAddress getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(VendorAddress vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

}
