package com.app.messdeck.model.dto;

public class AddressDTO {

	private long id;
	private String street;
	private String city;
	private String state;
	private String country;
	private String pinCode;

	public AddressDTO() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "AddressDTO [id=" + id + ", street=" + street + ", city=" + city + ", state=" + state + ", country="
				+ country + ", pinCode=" + pinCode + "]";
	}

}
