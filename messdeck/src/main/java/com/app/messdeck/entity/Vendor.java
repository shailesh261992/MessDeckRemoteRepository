package com.app.messdeck.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Vendor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "addressID",nullable=false)
	private Address vendorddress;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "ownerID",nullable=false)
	private Owner owner;

	@OneToMany(mappedBy = "vendor")
	private List<Customer> customers;

	@OneToMany(mappedBy = "vendor")
	private List<MessDeckService> services;

	public Vendor() {
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
		Vendor other = (Vendor) obj;
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
