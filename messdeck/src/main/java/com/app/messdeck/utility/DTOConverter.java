package com.app.messdeck.utility;

import java.util.ArrayList;
import java.util.List;

import com.app.messdeck.entity.Item;
import com.app.messdeck.entity.MessDeckService;
import com.app.messdeck.entity.Vendor;
import com.app.messdeck.model.dto.ItemDTO;
import com.app.messdeck.model.dto.MessDeckServiceDTO;
import com.app.messdeck.model.dto.VendorDTO;

public class DTOConverter {

	public static Vendor dTOToEntityCoverter(VendorDTO dto) {

		Vendor vendor = null;
		if (dto != null) {
			vendor = new Vendor();
			vendor.setId(dto.getId());
			vendor.setName(dto.getName());
			vendor.setOwner(dto.getOwner());
			vendor.setVendorddress(dto.getVendorddress());
		}

		return vendor;

	}

	public static VendorDTO entityToDTOConverter(Vendor vendor) {
		VendorDTO vendorDTO = null;
		if (vendor != null) {
			vendorDTO = new VendorDTO();

			vendorDTO.setId(vendor.getId());
			vendorDTO.setName(vendor.getName());
			vendorDTO.setVendorddress(vendor.getVendorddress());
			vendorDTO.setOwner(vendor.getOwner());

		}

		return vendorDTO;

	}

	public static MessDeckServiceDTO entityTODTOCoverterForMessDeckService(MessDeckService messDeckService) {
		MessDeckServiceDTO messDeckServiceDTO = null;
		if (messDeckService != null) {
			messDeckServiceDTO = new MessDeckServiceDTO();

			messDeckServiceDTO.setCapacityOfMembers(messDeckService.getCapacityOfMembers());
			messDeckServiceDTO.setCost(messDeckService.getCost());
			messDeckServiceDTO.setStartTime(messDeckService.getStartTime());
			messDeckServiceDTO.setEndTime(messDeckService.getEndTime());
			messDeckServiceDTO.setServiceType(messDeckService.getServiceType());
			messDeckServiceDTO.setDate(messDeckService.getDate());
			Vendor v = messDeckService.getVendor();

			messDeckServiceDTO.setVendorId(v.getId());
			messDeckServiceDTO.setId(messDeckService.getId());
			List<ItemDTO> lst = new ArrayList<ItemDTO>();

			for (Item i : messDeckService.getMeal()) {
				ItemDTO itemDTO = new ItemDTO();
				itemDTO.setCategory(i.getCategory());
				itemDTO.setDescription(i.getDescription());
				itemDTO.setName(i.getName());
				itemDTO.setId(i.getId());
				lst.add(itemDTO);
			}
			messDeckServiceDTO.setMeal(lst);
		}
		return messDeckServiceDTO;
	}

	public static MessDeckService dtoTOEntityCoverterForMessDeckService(MessDeckServiceDTO messDeckServiceDTO) {
		MessDeckService messDeckService = null;
		if (messDeckServiceDTO != null) {
			messDeckService = new MessDeckService();
			messDeckService.setId(messDeckServiceDTO.getId());
			messDeckService.setCapacityOfMembers(messDeckServiceDTO.getCapacityOfMembers());
			messDeckService.setCost(messDeckServiceDTO.getCost());
			messDeckService.setStartTime(messDeckServiceDTO.getStartTime());
			messDeckService.setEndTime(messDeckServiceDTO.getEndTime());
			messDeckService.setServiceType(messDeckServiceDTO.getServiceType());
			messDeckService.setDate(messDeckServiceDTO.getDate());
			Vendor v = new Vendor();
			List<Item> lst = new ArrayList<Item>();
			for (ItemDTO i : messDeckServiceDTO.getMeal()) {
				Item item = new Item();
				item.setCategory(i.getCategory());
				item.setDescription(i.getDescription());
				item.setName(i.getName());
				item.setId(i.getId());
				item.setService(messDeckService);
				lst.add(item);

			}
			System.out.println("****lst=" + lst);
			messDeckService.setMeal(lst);

			long vendorId = messDeckServiceDTO.getVendorId();
			v.setId(vendorId);

			messDeckService.setVendor(v);

		}
		return messDeckService;
	}

}
