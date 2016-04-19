package com.app.messdeck.repository;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.messdeck.configuration.MessDeckConfiguration;
import com.app.messdeck.entity.Item;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MessDeckConfiguration.class })
public class TestItemDAO {

	@Autowired
	private ItemDAO dao;

	@Test
	@Ignore
	public void test() {
		Item item1 = new Item("Rajama");
		Item item2 = new Item("Chaval");

		dao.create(item1);
		dao.create(item2);
	}

}
