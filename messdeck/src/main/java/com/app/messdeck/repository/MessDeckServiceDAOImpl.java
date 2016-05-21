package com.app.messdeck.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.messdeck.businessException.MessDeckServiceNotExistException;
import com.app.messdeck.entity.MessDeckService;
import com.app.messdeck.entity.Vendor;

@Repository

public class MessDeckServiceDAOImpl implements MessDeckServiceDAO {

	@Autowired
	private HibernateTemplate template;

	@Autowired
	private VendorDAO vendorDao;

	@Override
	public Long create(MessDeckService messDeckService) {
		Vendor vendor = vendorDao.get(messDeckService.getVendor().getId());
		messDeckService.setVendor(vendor);
		long id = (Long) template.save(messDeckService);

		return id;
	}

	@Override
	public void update(MessDeckService messDeckService) {
		get(messDeckService.getId());
		template.merge(messDeckService);

	}

	@Override
	public MessDeckService get(Long id) {
		MessDeckService messDeckService = template.get(MessDeckService.class, id);
		if (messDeckService != null) {
			return messDeckService;
		} else {
			throw new MessDeckServiceNotExistException(id);
		}
	}

	public void delete(MessDeckService messDeckService) {
		template.delete(messDeckService);

	}

	@Override
	public void delete(Long id) {
		MessDeckService messDeckService = get(id);
		template.delete(messDeckService);

	}

}
