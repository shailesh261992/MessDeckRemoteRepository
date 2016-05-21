package com.app.messdeck.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.messdeck.businessException.MessDeckServiceInfoNotExistException;
import com.app.messdeck.entity.MessDeckServiceInfo;
import com.app.messdeck.entity.Vendor;

@Repository

public class MessDeckServiceInfoDAOImpl implements MessDeckServiceInfoDAO {

	@Autowired
	private HibernateTemplate template;

	@Autowired
	private VendorDAO vendorDao;

	@Override
	public Long create(MessDeckServiceInfo messDeckService) {
		Vendor vendor = vendorDao.get(messDeckService.getVendor().getId());
		messDeckService.setVendor(vendor);
		long id = (Long) template.save(messDeckService);

		return id;
	}

	@Override
	public void update(MessDeckServiceInfo messDeckService) {
		Vendor vendor = vendorDao.get(messDeckService.getVendor().getId());
		messDeckService.setVendor(vendor);
		get(messDeckService.getId());
		template.merge(messDeckService);

	}

	@Override
	public MessDeckServiceInfo get(Long id) {
		MessDeckServiceInfo messDeckService = template.get(MessDeckServiceInfo.class, id);
		if (messDeckService != null) {
			return messDeckService;
		} else {
			throw new MessDeckServiceInfoNotExistException(id);
		}
	}

	public void delete(MessDeckServiceInfo messDeckService) {
		template.delete(messDeckService);

	}

	@Override
	public void delete(Long id) {
		MessDeckServiceInfo messDeckService = get(id);
		template.delete(messDeckService);

	}

}
