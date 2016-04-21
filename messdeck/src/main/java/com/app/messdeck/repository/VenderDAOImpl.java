package com.app.messdeck.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.messdeck.entity.Vendor;

@Repository
@Transactional
public class VenderDAOImpl implements VendorDAO {

	@Autowired
	private HibernateTemplate template;

	public Long create(Vendor obj) {
		return (Long) template.save(obj);
	}

	public void delete(Vendor obj) {
		template.delete(obj);

	}

	public void update(Vendor vendor) {
		template.update(vendor);
	}

	public Vendor get(long id) {
		return template.get(Vendor.class, id);
	}

	@Override
	public List<Vendor> getAll() {
		return template.loadAll(Vendor.class);
	}

}
