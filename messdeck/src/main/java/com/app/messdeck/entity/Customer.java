package com.app.messdeck.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Customer extends Person {

	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	// private long id;

	@OneToOne(cascade = CascadeType.ALL)
	// @PrimaryKeyJoinColumn
	private CustomerAddress customerAddress;

	@ManyToOne
	private Vendor vendor;

	@ManyToMany
	@JoinTable(name = "CustomerService", joinColumns = { @JoinColumn(name = "subscriber") }, inverseJoinColumns = {
			@JoinColumn(name = "mess_deck_service") })
	private List<MessDeckServiceInfo> subscribedServices;

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

	public List<MessDeckServiceInfo> getSubscribedServices() {
		return subscribedServices;
	}

	public void setSubscribedServices(List<MessDeckServiceInfo> subscribedServices) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
