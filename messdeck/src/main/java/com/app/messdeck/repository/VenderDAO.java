package com.app.messdeck.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.messdeck.model.Vendor;

@Repository
@Transactional
public class VenderDAO {

	@Autowired
	private HibernateTemplate template;

	public void create(Vendor obj) {
		template.save(obj);
	}

	public void delete(Vendor obj) {
		template.delete(obj);

	}

	public void update(Vendor obj) {
		template.update(obj);

	}

	public Vendor read(long id) {
		return template.get(Vendor.class, id);
	}

}
