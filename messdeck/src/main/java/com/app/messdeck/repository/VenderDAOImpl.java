package com.app.messdeck.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.messdeck.businessException.VendorNotExistException;
import com.app.messdeck.entity.Owner;
import com.app.messdeck.entity.Vendor;
import com.app.messdeck.entity.VendorAddress;

@Repository
@Transactional
public class VenderDAOImpl implements VendorDAO {

	@Autowired
	private HibernateTemplate template;

	public Long create(Vendor vendor) {

		Owner owner = vendor.getOwner();
		VendorAddress vendorddress = vendor.getVendorAddress();

		detachVendorFromAddressAndOwner(vendor);
		template.save(vendor);
		attchVendorWithAddressAndOwner(vendor, owner, vendorddress);
		attchVendorIDToOwnerOwneraddressVendoraddress(vendor);
		template.save(vendor);
		return vendor.getId();
	}

	public void delete(Vendor obj) {
		template.delete(obj);

	}

	public void update(Vendor vendor) {

		Vendor v = this.get(vendor.getId());

		if (v != null) {
			vendor.getOwner().setId(v.getOwner().getId());
			vendor.getOwner().getOwnerAddress().setId(v.getOwner().getOwnerAddress().getId());
			vendor.getVendorAddress().setId(v.getVendorAddress().getId());
			template.merge(vendor);
		} else {
			throw new VendorNotExistException(vendor.getId());
		}

	}

	public Vendor get(long id) {
		return template.get(Vendor.class, id);
	}

	@Override
	public List<Vendor> getAll() {
		return template.loadAll(Vendor.class);
	}

	private void detachVendorFromAddressAndOwner(Vendor vendor) {
		vendor.setOwner(null);
		vendor.setVendorAddress(null);
	}

	private void attchVendorWithAddressAndOwner(Vendor vendor, Owner owner, VendorAddress vendorddress) {
		vendor.setOwner(owner);
		vendor.setVendorAddress(vendorddress);
	}

	private Vendor attchVendorIDToOwnerOwneraddressVendoraddress(Vendor vendor) {
		System.out.println("**** vendor = " + vendor);
		vendor.getOwner().setId(vendor.getId());
		vendor.getOwner().getOwnerAddress().setId(vendor.getId());
		vendor.getVendorAddress().setId(vendor.getId());
		return vendor;
	}
}
