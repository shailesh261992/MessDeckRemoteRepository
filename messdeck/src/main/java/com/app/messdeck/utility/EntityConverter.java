package com.app.messdeck.utility;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.app.messdeck.entity.Customer;
import com.app.messdeck.entity.MessDeckServiceInfo;
import com.app.messdeck.entity.Vendor;
import com.app.messdeck.model.dto.CustomerDTO;
import com.app.messdeck.model.dto.MessDeckServiceInfoDTO;
import com.app.messdeck.model.dto.VendorDTO;

public class EntityConverter {

	public static VendorDTO getVendorSummaryDTO(Vendor vendor) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<Vendor, VendorDTO>() {

			@Override
			protected void configure() {
				skip().setOwner(null);
				skip().setCustomers(null);
				skip().setServices(null);

			}
		});

		VendorDTO dto = modelMapper.map(vendor, VendorDTO.class);
		System.out.println("VendorSummary = " + dto);
		return dto;

	}

	public static VendorDTO getVendorDetailsDTO(Vendor vendor) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<Vendor, VendorDTO>() {

			@Override
			protected void configure() {
				skip().setCustomers(null);
				skip().setServices(null);

			}
		});

		VendorDTO dto = modelMapper.map(vendor, VendorDTO.class);
		System.out.println("VendorSummary = " + dto);
		return dto;

	}

	public static CustomerDTO getCustomorSummaryDTO(Customer customer) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<Customer, CustomerDTO>() {

			@Override
			protected void configure() {
				skip().setSubscribedServices(null);
				skip().getVendor().setCustomers(null);
				skip().getVendor().setOwner(null);
				skip().getVendor().setServices(null);

			}
		});

		CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
		System.out.println("CustomerDTO Summary = " + customer);
		return customerDTO;

	}

	public static MessDeckServiceInfoDTO getMessDeckServiceInfoDTO(MessDeckServiceInfo messDeckService) {

		ModelMapper modelMapper = new ModelMapper();

		modelMapper.addMappings(new PropertyMap<MessDeckServiceInfo, MessDeckServiceInfoDTO>() {

			@Override
			protected void configure() {
				skip().getVendor().setCustomers(null);
				skip().getVendor().setServices(null);
				skip().getVendor().setOwner(null);
				// skip().setMeal(null);

			}
		});

		MessDeckServiceInfoDTO dto = modelMapper.map(messDeckService, MessDeckServiceInfoDTO.class);
		return dto;
	}

}
