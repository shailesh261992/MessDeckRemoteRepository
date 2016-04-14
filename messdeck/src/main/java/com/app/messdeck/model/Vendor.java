package com.app.messdeck.model;

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
	@JoinColumn(name="addressID")
	private Address address;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name="ownerID")
	private Owner owner;

	@OneToMany(mappedBy="vendor")
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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

}
