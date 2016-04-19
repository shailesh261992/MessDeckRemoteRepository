package com.app.messdeck.model.dto;

import java.util.Date;
import java.util.List;

import com.app.messdeck.model.Customer;
import com.app.messdeck.model.Item;
import com.app.messdeck.model.ServiceType;
import com.app.messdeck.model.Vendor;

public class MessDeckServiceDTO {
	
	private long id;
	

	private Vendor vendor;

	
	private ServiceType serviceType;
	
	
	private Date date;

	
	
	private List<Item> meal;
	private double cost;

	
	private List<Customer> subscribers;

	public MessDeckServiceDTO(Vendor vendor, ServiceType serviceType, Date date, List<Item> meal, double cost) {
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
