package com.app.messdeck.model.dto;

import java.util.List;

import com.app.messdeck.model.Address;
import com.app.messdeck.model.Customer;
import com.app.messdeck.model.MessDeckService;
import com.app.messdeck.model.Owner;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class VendorDTO {

	private long id;
	private String name;

	private Address vendorddress;

	private Owner owner;

	private List<Customer> customers;

	private List<MessDeckService> services;

	public VendorDTO() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public List<MessDeckService> getServices() {
		return services;
	}

	public void setServices(List<MessDeckService> services) {
		this.services = services;
	}

	public Address getVendorddress() {
		return vendorddress;
	}

	public void setVendorddress(Address vendorddress) {
		this.vendorddress = vendorddress;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", vendorddress=" + vendorddress + ", owner=" + owner
				+ ", customers=" + customers + ", services=" + services + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VendorDTO other = (VendorDTO) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		return true;
	}

}
