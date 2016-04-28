package com.app.messdeck.model.dto;

import java.util.Date;
import java.util.List;

import com.app.messdeck.entity.ServiceType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class MessDeckServiceDTO {

	private long id;

	private long vendorId;

	private ServiceType serviceType;

	// startTime
	// endTime
	// capacityOfMembers

	private Integer capacityOfMembers;

	@JsonDeserialize(using = TimeDeserializer.class)
	private Date startTime;

	@JsonDeserialize(using = TimeDeserializer.class)
	private Date endTime;

	private Date date;

	private List<ItemDTO> meal;
	private double cost;

	public MessDeckServiceDTO() {

	}

	public MessDeckServiceDTO(long vendorDTO, ServiceType serviceType, Date date, List<ItemDTO> meal, double cost) {
		super();
		this.vendorId = vendorId;
		this.serviceType = serviceType;
		this.date = date;
		this.meal = meal;
		this.cost = cost;
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

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getVendorId() {
		return vendorId;
	}

	public void setVendorId(long vendorId) {
		this.vendorId = vendorId;

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

	public List<ItemDTO> getMeal() {
		return meal;
	}

	public void setMeal(List<ItemDTO> meal) {
		this.meal = meal;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
