package com.app.messdeck.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.messdeck.entity.MessDeckService;

@Repository
@Transactional
public class MessageDeckServiceDAO {
	@Autowired
	private HibernateTemplate template;

	public void create(MessDeckService obj) {
		template.save(obj);
	}

	public void delete(MessDeckService obj) {
		template.delete(obj);

	}

	public void update(MessDeckService obj) {
		template.update(obj);

	}

	public MessDeckService read(long id) {
		return template.get(MessDeckService.class, id);
	}

}
