package com.app.messdeck.model.dto;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.app.messdeck.entity.EmailID;
import com.app.messdeck.entity.Name;
import com.app.messdeck.entity.Owner;
import com.app.messdeck.entity.OwnerAddress;
import com.app.messdeck.entity.Vendor;
import com.app.messdeck.entity.VendorAddress;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import net.sf.oval.constraint.AssertValid;
import net.sf.oval.constraint.MatchPattern;
import net.sf.oval.constraint.NotNull;

@JsonInclude(Include.NON_EMPTY)
public class VendorDTO {

	private long id;
	@MatchPattern(pattern = "^[a-zA-Z ]*$", message = "Only Alphabets are allowed")
	@NotNull
	private String name;

	@AssertValid(message = "Invalid Vendor Address")
	private VendorAddressDTO vendorAddress;

	@AssertValid(message = "Invalid Owner")
	private OwnerDTO owner;

	private List<CustomerDTO> customers;

	private List<MessDeckServiceDTO> services;

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

	public List<MessDeckServiceDTO> getServices() {
		return services;
	}

	public void setServices(List<MessDeckServiceDTO> services) {
		this.services = services;
	}

	public VendorAddressDTO getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(VendorAddressDTO vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public List<CustomerDTO> getCustomers() {
		return customers;
	}

	public void setCustomers(List<CustomerDTO> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", vendorddress=" + vendorAddress + "]";
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
