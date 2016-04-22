package com.app.messdeck.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.messdeck.entity.Owner;

@Repository
@Transactional
public class OwnerDAOImpl {

	@Autowired
	private HibernateTemplate template;

	public Long create(Owner obj) {
		return (Long) template.save(obj);
	}
}
