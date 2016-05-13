package com.app.messdeck.model.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import net.sf.oval.constraint.AssertValid;

@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDTO extends PersonDTO {

	private long id;

	@AssertValid(message = "Invalid Customer Address")
	private CustomerAddressDTO customerAddress;

	@NotNull
	private VendorDTO vendor;

	@JsonIgnore
	private List<MessDeckServiceDTO> subscribedServices;

	public CustomerDTO() {
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

	public List<MessDeckServiceDTO> getSubscribedServices() {
		return subscribedServices;
	}

	public void setSubscribedServices(List<MessDeckServiceDTO> subscribedServices) {
		this.subscribedServices = subscribedServices;
	}

	public CustomerAddressDTO getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(CustomerAddressDTO customerAddress) {
		this.customerAddress = customerAddress;
	}

	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", customerAddress=" + customerAddress + ", vendor=" + vendor + ", person"
				+ super.toString() + "]";
	}

}
