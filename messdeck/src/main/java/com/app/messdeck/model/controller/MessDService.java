package com.app.messdeck.model.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.messdeck.model.Address;
import com.app.messdeck.model.EmailID;
import com.app.messdeck.model.Item;
import com.app.messdeck.model.MessDeckService;
import com.app.messdeck.model.Name;
import com.app.messdeck.model.Owner;
import com.app.messdeck.model.ServiceType;
import com.app.messdeck.model.Vendor;

@Controller
public class MessDService {

	@RequestMapping(value = "/services", method = RequestMethod.GET)

	public @ResponseBody List<MessDeckService> getServices() {

		ArrayList<MessDeckService> arrayList = new ArrayList<MessDeckService>();
		Item item1 = new Item("Rajama");
		Item item2 = new Item("Chaval");

		List<Item> meal = new ArrayList<Item>();
		meal.add(item1);
		meal.add(item2);

		Vendor v = new Vendor();
		v.setName("Sai Mess");

		Owner o = new Owner();
		o.setName(new Name("Shailesh", "Kadam"));
		o.setEmailID(new EmailID("shailesh261992@gmail.com"));

		Address address = new Address();
		address.setCity("pune");
		v.setAddress(address);
		v.setOwner(o);

		MessDeckService messDeckService = new MessDeckService(v, ServiceType.TIFFIN, new Date(), meal, 100);
		arrayList.add(messDeckService);
		return arrayList;

	}

}
