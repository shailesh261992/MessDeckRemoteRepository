package com.app.messdeck.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class MessDeckService {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne
	
	@JoinColumn(nullable = false,name="vendorID")
	private Vendor vendor;

	@Column(nullable = false)
	private ServiceType serviceType;
	
	@Column(nullable = false)
	private Date date;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Service_ItemList")
	private List<Item> meal;
	private double cost;

	@ManyToMany(mappedBy = "subscribedServices")
	private List<Customer> subscribers;

	public MessDeckService(Vendor vendor, ServiceType serviceType, Date date, List<Item> meal, double cost) {
		super();
		this.vendor = vendor;
		this.serviceType = serviceType;
		this.date = date;
		this.meal = meal;
		this.cost = cost;
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

	public ServiceType serviceType() {
		return serviceType;
	}

	public void setService(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Item> getMeal() {
		return meal;
	}

	public void setMeal(List<Item> meal) {
		this.meal = meal;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public List<Customer> getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(List<Customer> subscribers) {
		this.subscribers = subscribers;
	}

}
