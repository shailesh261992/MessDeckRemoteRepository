package com.app.messdeck.model.dto;

import java.util.List;


import org.springframework.beans.BeanUtils;

import com.app.messdeck.entity.Customer;
import com.app.messdeck.entity.MessDeckService;
import com.app.messdeck.entity.Vendor;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import net.sf.oval.constraint.Size;



@JsonInclude(Include.NON_EMPTY)

public class VendorDTO {

	private long id;
	
	@Size(max=2)
	private String name;

	private VendorAddressDTO vendorAddress;

	private OwnerDTO owner;

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

	public OwnerDTO getOwner() {
		return owner;
	}

	public void setOwner(OwnerDTO owner) {
		this.owner = owner;
	}

	public List<MessDeckService> getServices() {
		return services;
	}

	public void setServices(List<MessDeckService> services) {
		this.services = services;
	}

	public VendorAddressDTO getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(VendorAddressDTO vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", vendorddress=" + vendorAddress + ", owner=" + owner
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

	public Vendor toVendor() {
		Vendor vendor = new Vendor();
		BeanUtils.copyProperties(this, vendor);
		BeanUtils.copyProperties(this.getVendorAddress(), vendor.getVendorAddress());
		BeanUtils.copyProperties(this.getOwner(), vendor.getOwner());
		BeanUtils.copyProperties(this.getOwner().getOwnerAddress(), vendor.getOwner().getOwnerAddress());

		return vendor;

	}
}
