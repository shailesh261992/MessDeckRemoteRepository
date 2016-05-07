package com.app.messdeck.model.dto;

import java.util.List;

import com.app.messdeck.entity.MessDeckService;
import com.app.messdeck.entity.Vendor;

public class CustomerDTO extends PersonDTO {

	private long id;
	private Vendor vendor;
	private List<MessDeckService> subscribedServices;

	public CustomerDTO() {
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

	public List<MessDeckService> getSubscribedServices() {
		return subscribedServices;
	}

	public void setSubscribedServices(List<MessDeckService> subscribedServices) {
		this.subscribedServices = subscribedServices;
	}

	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", vendor=" + vendor + ", person=" + super.toString() + "]";
	}

}
