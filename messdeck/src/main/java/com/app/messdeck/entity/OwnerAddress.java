package com.app.messdeck.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class OwnerAddress extends Address {
	@Id
	@GeneratedValue(generator = "foreigngen")
	@GenericGenerator(strategy = "foreign", name = "foreigngen", parameters = @Parameter(name = "property", value = "owner") )
	@Column(name = "id")
	private long id;

	@OneToOne(mappedBy = "ownerAddress")
	private Owner owner;

	public long getId() {
		return id;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "OwnerAddress [id=" + id + "]";
	}

}
