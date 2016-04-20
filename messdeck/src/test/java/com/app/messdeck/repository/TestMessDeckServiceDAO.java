package com.app.messdeck.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.messdeck.configuration.MessDeckConfiguration;
import com.app.messdeck.entity.Address;
import com.app.messdeck.entity.EmailID;
import com.app.messdeck.entity.Item;
import com.app.messdeck.entity.MessDeckService;
import com.app.messdeck.entity.Name;
import com.app.messdeck.entity.Owner;
import com.app.messdeck.entity.ServiceType;
import com.app.messdeck.entity.Vendor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MessDeckConfiguration.class })
public class TestMessDeckServiceDAO {

	@Autowired
	private VenderDAOImpl vdao;

	/*
	 * @Autowired private MessageDeckServiceDAO dao;
	 */

	@Ignore
	@Test
	public void test() {
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
		// v.setAddress(address);
		v.setOwner(o);

		vdao.create(v);

		MessDeckService messDeckService = new MessDeckService(v, ServiceType.TIFFIN, new Date(), meal, 100);
		// dao.create(messDeckService);

	}

}
