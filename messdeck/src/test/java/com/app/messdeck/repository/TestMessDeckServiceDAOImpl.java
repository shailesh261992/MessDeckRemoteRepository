package com.app.messdeck.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.app.messdeck.configuration.MessDeckConfiguration;
import com.app.messdeck.entity.Item;
import com.app.messdeck.entity.MessDeckService;
import com.app.messdeck.entity.ServiceType;
import com.app.messdeck.entity.Vendor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MessDeckConfiguration.class })
@WebAppConfiguration
public class TestMessDeckServiceDAOImpl {

	@Autowired
	private MessDeckServiceDAO messDeckServiceDAO;

	private MessDeckService createMessDeckSerivce() {
		MessDeckService messDeckService = new MessDeckService();
		messDeckService.setCapacityOfMembers(100);
		messDeckService.setCost(100);
		messDeckService.setDate(new Date());

		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 17);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		Date startDate = c.getTime();

		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.HOUR_OF_DAY, 19);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);
		Date endDate = c1.getTime();

		messDeckService.setEndTime(endDate);
		messDeckService.setStartTime(startDate);
		messDeckService.setServiceType(ServiceType.DINNER);
		messDeckService.setVendor(createVendor());

		List<Item> lst = new ArrayList<Item>();
		Item itemDTO = new Item();

		itemDTO.setCategory("xxx");
		itemDTO.setDescription("salad");
		itemDTO.setName("YYYsss");
		lst.add(itemDTO);
		messDeckService.setMeal(lst);

		return messDeckService;

	}

	@Test
	@Transactional
	public void testSaveMessDeckService() {
		Long l = messDeckServiceDAO.create(createMessDeckSerivce());
		Assert.assertNotNull(l);
	}

	private Vendor createVendor() {
		Vendor v = new Vendor();
		v.setId(1L);
		return v;

	}

}
