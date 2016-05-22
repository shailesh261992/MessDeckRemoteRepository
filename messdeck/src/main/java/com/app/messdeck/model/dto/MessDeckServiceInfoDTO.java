package com.app.messdeck.model.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.app.messdeck.customvalidations.IsValidMessDeckServiceDate;
import com.app.messdeck.entity.ServiceType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

import net.sf.oval.constraint.Assert;
import net.sf.oval.constraint.CheckWith;
import net.sf.oval.constraint.NotNull;

public class MessDeckServiceInfoDTO {

	private long id;

	@NotNull(message = "Vendor can not be null,Only vendors are allowed to publish service")
	private VendorDTO vendor;

	@NotNull(message = "Service Type can not be null")
	private ServiceType serviceType;

	@Assert(expr = "_this.capacityOfMembers > 0", lang = "js", message = "Member Capacity must be greater than 0(Zero)")
	private Integer capacityOfMembers;

	@JsonDeserialize(using = LocalTimeDeserializer.class)
	@JsonSerialize(using = LocalTimeSerializer.class)
	@Assert(expr = "_this.startTime < _this.endTime", lang = "js", message = "Service start time must be less than end time")
	private LocalTime startTime;

	@JsonDeserialize(using = LocalTimeDeserializer.class)
	@JsonSerialize(using = LocalTimeSerializer.class)
	private LocalTime endTime;

	@CheckWith(value = IsValidMessDeckServiceDate.class, message = "Date must be greate than eq to current date & must be less than laste date in next month")
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate date;

	private List<ItemDTO> meal;

	@Assert(expr = "_this.cost > 0", lang = "js", message = "Cost must be greater than 0(Zero)")
	private double cost;

	private List<CustomerDTO> subscribers;

	public MessDeckServiceInfoDTO() {

	}

	public MessDeckServiceInfoDTO(VendorDTO vendor, ServiceType serviceType, LocalDate date, List<ItemDTO> meal,
			double cost) {
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

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capacityOfMembers == null) ? 0 : capacityOfMembers.hashCode());
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((meal == null) ? 0 : meal.hashCode());
		result = prime * result + ((serviceType == null) ? 0 : serviceType.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((vendor == null) ? 0 : vendor.hashCode());
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
		MessDeckServiceInfoDTO other = (MessDeckServiceInfoDTO) obj;
		if (capacityOfMembers == null) {
			if (other.capacityOfMembers != null)
				return false;
		} else if (!capacityOfMembers.equals(other.capacityOfMembers))
			return false;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (meal == null) {
			if (other.meal != null)
				return false;
		} else if (!meal.equals(other.meal))
			return false;
		if (serviceType != other.serviceType)
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (vendor == null) {
			if (other.vendor != null)
				return false;
		} else if (!vendor.equals(other.vendor))
			return false;
		return true;
	}

}
