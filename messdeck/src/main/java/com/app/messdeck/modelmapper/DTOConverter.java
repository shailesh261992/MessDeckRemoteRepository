package com.app.messdeck.modelmapper;

import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.app.messdeck.entity.Customer;
import com.app.messdeck.entity.MessDeckServiceInfo;
import com.app.messdeck.entity.Vendor;
import com.app.messdeck.model.dto.CustomerDTO;
import com.app.messdeck.model.dto.MessDeckServiceInfoDTO;
import com.app.messdeck.model.dto.VendorDTO;

public class DTOConverter {
	private static Logger logger = Logger.getLogger(DTOConverter.class);

	public static Vendor getVendor(VendorDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<VendorDTO, Vendor>() {

			@Override
			protected void configure() {
				skip().setCustomers(null);
				skip().setServices(null);

			}
		});

		return modelMapper.map(dto, Vendor.class);
	}

	public static Customer getCustomer(CustomerDTO dto) {

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<CustomerDTO, Customer>() {

			@Override
			protected void configure() {

				skip().setSubscribedServices(null);
				skip().getVendor().setCustomers(null);
				skip().getVendor().setOwner(null);
				skip().getVendor().setServices(null);

			}
		});

		Customer customer = modelMapper.map(dto, Customer.class);
		return customer;

	}

	public static MessDeckServiceInfo getMessDeckServiceInfo(MessDeckServiceInfoDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new MessDeckServiceDTOMap());
		modelMapper.addMappings(new ItemDTOMap());
		return modelMapper.map(dto, MessDeckServiceInfo.class);
	}

}
