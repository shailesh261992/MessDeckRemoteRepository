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

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Service_Meal", joinColumns = @JoinColumn(name = "serviceId") , inverseJoinColumns = @JoinColumn(name = "itemId") )
	private List<Item> meal;

	private double cost;

	@ManyToMany(mappedBy = "subscribedServices")
	private List<Customer> subscribers;

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

	public List<Customer> getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(List<Customer> subscribers) {
		this.subscribers = subscribers;
	}

	@Override
	public String toString() {
		return "MessDeckService [id=" + id + ", vendor=" + vendor + ", serviceType=" + serviceType + ", date=" + date
				+ ", meal=" + meal + ", cost=" + cost + ", capacityOfMembers=" + capacityOfMembers + ", startTime="
				+ startTime + ", endTime=" + endTime + "]";
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
		MessDeckService other = (MessDeckService) obj;
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
