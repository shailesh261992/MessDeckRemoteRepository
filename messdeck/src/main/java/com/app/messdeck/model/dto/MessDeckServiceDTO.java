package com.app.messdeck.model.dto;

import java.util.Date;
import java.util.List;

import com.app.messdeck.entity.ServiceType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import net.sf.oval.constraint.Assert;
import net.sf.oval.constraint.NotNull;

public class MessDeckServiceDTO {

	private long id;

	@NotNull(message = "Vendor can not be null,Only vendors are allowed to publish service")
	private VendorDTO vendor;

	private ServiceType serviceType;

	@Assert(expr = "_this.capacityOfMembers > 0", lang = "js", message = "Member Capacity must be greater than 0(Zero)")
	private Integer capacityOfMembers;

	@JsonDeserialize(using = TimeDeserializer.class)
	private Date startTime;

	@JsonDeserialize(using = TimeDeserializer.class)
	private Date endTime;

	private Date date;

	private List<ItemDTO> meal;

	@Assert(expr = "_this.cost > 0", lang = "js", message = "Cost must be greater than 0(Zero)")
	private double cost;

	private List<CustomerDTO> subscribers;

	public MessDeckServiceDTO() {

	}

	public MessDeckServiceDTO(VendorDTO vendor, ServiceType serviceType, Date date, List<ItemDTO> meal, double cost) {
		super();
		this.vendor = vendor;
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

	public VendorDTO getVendor() {
		return vendor;
	}

	public void setVendor(VendorDTO vendor) {
		this.vendor = vendor;
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

	public List<CustomerDTO> getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(List<CustomerDTO> subscribers) {
		this.subscribers = subscribers;
	}

	@Override
	public String toString() {
		return "MessDeckServiceDTO [id=" + id + ", vendor=" + vendor + ", serviceType=" + serviceType
				+ ", capacityOfMembers=" + capacityOfMembers + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", date=" + date + ", meal=" + meal + ", cost=" + cost + "]";
	}

}
