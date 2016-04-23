package com.app.messdeck.repository;

import static com.app.messdeck.repository.testData.SampleVendorData.getVendorOne;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.app.messdeck.configuration.MessDeckConfiguration;
import com.app.messdeck.entity.Owner;
import com.app.messdeck.entity.OwnerAddress;
import com.app.messdeck.entity.Vendor;
import com.app.messdeck.entity.VendorAddress;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MessDeckConfiguration.class })
@WebAppConfiguration
public class TestVendorDAO {

	@Autowired
	private VendorDAO dao;

	@Autowired
	private HibernateTemplate template;

	@Test
	@Transactional
	@Rollback()
	public void create() {
		Long id = dao.create(getVendorOne());
		assertEquals(1, dao.getAll().size());
		assertNotNull(template.get(Owner.class, id));
		assertNotNull(template.get(OwnerAddress.class, id));
		assertNotNull(template.get(VendorAddress.class, id));

	}

	@Test
	@Transactional
	public void read() {
		Long id = dao.create(getVendorOne());
		Vendor vendor = dao.get(id);
		assertEquals(getVendorOne().getOwner(), vendor.getOwner());
		assertEquals(getVendorOne().getVendorAddress(), vendor.getVendorAddress());
		assertEquals(getVendorOne().getOwner().getOwnerAddress(), vendor.getOwner().getOwnerAddress());

	}

	@Test
	@Transactional
	public void delete() {
		Long id = dao.create(getVendorOne());
		Vendor vendor = dao.get(id);
		dao.delete(vendor);
		assertEquals(0, template.loadAll(Vendor.class).size());
		assertEquals(null, template.get(Owner.class, id));
		assertEquals(null, template.get(OwnerAddress.class, id));
		assertEquals(null, template.get(VendorAddress.class, id));
	}

	@Test
	@Transactional
	public void update() {
		Long id = dao.create(getVendorOne());
		Vendor v = dao.get(id);

		Owner owner = new Owner();
		OwnerAddress ownerAddress = new OwnerAddress();
		ownerAddress.setCity("Satara");
		owner.setOwnerAddress(ownerAddress);
		v.getOwner().setOwnerAddress(ownerAddress);

		dao.update(v);
		assertEquals("Satara", dao.get(id).getOwner().getOwnerAddress().getCity());

	}

}
