package com.app.messdeck.repository;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.messdeck.businessException.MessDeckServiceInfoNotExistException;
import com.app.messdeck.businessException.NotVendorWhoCreatesServiceException;
import com.app.messdeck.entity.MessDeckServiceInfo;
import com.app.messdeck.entity.Vendor;

@Repository

public class MessDeckServiceInfoDAOImpl implements MessDeckServiceInfoDAO {

	@Autowired
	private HibernateTemplate template;

	@Autowired
	private VendorDAO vendorDao;

	@Override
	@Transactional
	public Long create(MessDeckServiceInfo messDeckService) {
		Vendor vendor = vendorDao.get(messDeckService.getVendor().getId());
		messDeckService.setVendor(vendor);
		long id = (Long) template.save(messDeckService);

		return id;
	}

	@Override
	@Transactional
	public void update(MessDeckServiceInfo messDeckService) {

		MessDeckServiceInfo fetchedmessDeckServiceInfo = get(messDeckService.getId());
		if (fetchedmessDeckServiceInfo.getVendor().equals(messDeckService.getVendor())){
			messDeckService.setVendor(fetchedmessDeckServiceInfo.getVendor());
			template.merge(messDeckService);
		}else{
			throw new NotVendorWhoCreatesServiceException(messDeckService);
		}
		
		

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

	@Transactional
	public void delete(MessDeckServiceInfo messDeckService) {
		template.delete(messDeckService);

	}

	@Override
	@Transactional
	public void delete(Long id) {
		MessDeckServiceInfo messDeckService = get(id);
		template.delete(messDeckService);

	}

}
