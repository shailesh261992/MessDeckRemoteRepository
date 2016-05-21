package com.app.messdeck.testData;

import java.util.ArrayList;
import java.util.Date;

import com.app.messdeck.entity.ServiceType;
import com.app.messdeck.model.dto.CustomerDTO;
import com.app.messdeck.model.dto.ItemDTO;
import com.app.messdeck.model.dto.MessDeckServiceDTO;
import com.app.messdeck.testutils.TestUtils;

public class MessDeckServiceDTODataSample {
	public static MessDeckServiceDTO getMessDeckServiceDTO() {
		MessDeckServiceDTO dto = new MessDeckServiceDTO();
		dto.setCapacityOfMembers(50);
		dto.setCost(100);
		dto.setDate(new Date());

		Date startTime = TestUtils.getTime(20, 0, 0);
		Date endTime = TestUtils.getTime(21, 0, 0);

		dto.setStartTime(startTime);
		dto.setEndTime(endTime);
		dto.setServiceType(ServiceType.DINNER);
		dto.setVendor(VendorDTODataSample.getVendorDTO());

		ArrayList<ItemDTO> items = new ArrayList<>();
		ItemDTO itemDTO1 = new ItemDTO();
		 itemDTO1.setId(1);
		itemDTO1.setName("Egg curry");
		itemDTO1.setDescription("Eggs cury description");

		ItemDTO itemDTO2 = new ItemDTO();
		//itemDTO2.setId(2);
		itemDTO2.setName("Chapatai");
		itemDTO2.setDescription("Wheat Chapati Description");

		ItemDTO itemDTO3 = new ItemDTO();
		// itemDTO3.setId(3);
		itemDTO3.setName("Rice");
		itemDTO3.setDescription("Rice Description");

		items.add(itemDTO1);
		items.add(itemDTO2);
		items.add(itemDTO3);

		ArrayList<CustomerDTO> subscribers = new ArrayList<>();
		subscribers.add(CustomerDTODataSample.getCustomerDTO());
		dto.setSubscribers(subscribers);

		dto.setMeal(items);

		return dto;

	}

}
