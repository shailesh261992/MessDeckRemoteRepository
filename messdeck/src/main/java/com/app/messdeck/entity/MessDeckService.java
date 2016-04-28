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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class MessDeckService {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne

	@JoinColumn(nullable = false, name = "vendorID")
	private Vendor vendor;

	@Column(nullable = false)
	private ServiceType serviceType;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "service")
	private List<Item> meal;
	private double cost;

	// @ManyToMany(mappedBy = "subscribedServices")
	// private List<Customer> subscribers;

	private Integer capacityOfMembers;

	@Temporal(TemporalType.TIME)
	private Date startTime;

	@Temporal(TemporalType.TIME)
	private Date endTime;

	public MessDeckService() {

	}

	public MessDeckService(Vendor vendor, ServiceType serviceType, Date date, List<Item> meal, double cost) {
		super();
		this.vendor = vendor;
		this.serviceType = serviceType;
		this.date = date;
		this.meal = meal;
		this.cost = cost;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public Integer getCapacityOfMembers() {
		return capacityOfMembers;
	}

	public void setCapacityOfMembers(Integer capacityOfMembers) {
		this.capacityOfMembers = capacityOfMembers;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
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

	// public List<Customer> getSubscribers() {
	// return subscribers;
	// }
	//
	// public void setSubscribers(List<Customer> subscribers) {
	// this.subscribers = subscribers;
	// }

}
