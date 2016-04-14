package com.app.messdeck.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.messdeck.model.Item;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:DefaultServlet-servlet.xml" })
public class TestItemDAO {

	@Autowired
	private ItemDAO dao;

	@Test
	public void test() {
		Item item1 = new Item("Rajama");
		Item item2 = new Item("Chaval");

		dao.create(item1);
		dao.create(item2);
	}

}
