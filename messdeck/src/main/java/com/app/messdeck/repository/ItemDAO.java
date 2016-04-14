package com.app.messdeck.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.messdeck.model.Item;

@Repository
@Transactional
public class ItemDAO {
	@Autowired
	private HibernateTemplate template;

	public void create(Item obj) {
		template.save(obj);
	}

	public void delete(Item obj) {
		template.delete(obj);

	}

	public void update(Item obj) {
		template.update(obj);

	}

	public Item read(long id) {
		return template.get(Item.class, id);
	}
}
