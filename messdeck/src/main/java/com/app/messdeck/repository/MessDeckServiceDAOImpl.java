package com.app.messdeck.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.messdeck.entity.MessDeckService;

@Repository

public class MessDeckServiceDAOImpl implements MessDeckServiceDAO {

	@Autowired
	private HibernateTemplate template;

	@Override
	public Long saveMessDeckService(MessDeckService messDeckService) {
		// TODO Auto-generated method stub
		// template.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		long l = (Long) template.save(messDeckService);
		template.clear();
		return l;
	}

	@Override
	public void update(MessDeckService messDeckService) {
		// TODO Auto-generated method stub

		template.update(messDeckService);

	}

	@Override
	public MessDeckService getMessDeckService(Long id) {
		return template.get(MessDeckService.class, id);
	}

	@Override
	public void delete(MessDeckService messDeckService) {
		template.delete(messDeckService);

	}

}
