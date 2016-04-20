package com.app.messdeck.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.app.messdeck.configuration.MessDeckConfiguration;
import com.app.messdeck.entity.Address;
import com.app.messdeck.entity.EmailID;
import com.app.messdeck.entity.Gender;
import com.app.messdeck.entity.Name;
import com.app.messdeck.entity.Owner;
import com.app.messdeck.entity.Vendor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MessDeckConfiguration.class })
@WebAppConfiguration
public class TestVendorDAO {

	@Autowired
	private VendorDAO dao;

	private Vendor mess;
	private Long generatedMessId;

	// private Vendor createAndhraVendor() {
	// Vendor andhraMess = new Vendor();
	// andhraMess.setName("Andhra Mess");
	//
	// Owner saiMessOwner = new Owner();
	// saiMessOwner.setName(new Name("Nikunj", "Viramgama"));
	// saiMessOwner.setEmailID(new EmailID("nikunj.virmgama@gmail.com"));
	// saiMessOwner.setMobileNo("7030239888");
	// Address ownerAddress = new Address();
	// ownerAddress.setCity("pimplae-saudagar");
	// saiMessOwner.setAddress(ownerAddress);
	// saiMessOwner.setGender(Gender.MALE);
	//
	// Address vendorAddress = new Address();
	// vendorAddress.setCity("Hinjewadi");
	//
	// andhraMess.setAddress(vendorAddress);
	// andhraMess.setOwner(saiMessOwner);
	// return andhraMess;
	// }

	private Vendor createSaiVendor() {
		Vendor saiMess = new Vendor();
		saiMess.setName("Sai Mess");

		Owner saiMessOwner = new Owner();
		saiMessOwner.setName(new Name("Shailesh", "Kadam"));
		saiMessOwner.setEmailID(new EmailID("shailesh261992@gmail.com"));
		saiMessOwner.setMobileNo("7276248187");
		Address ownerAddress = new Address();
		ownerAddress.setCity("pimpari");
		saiMessOwner.setAddress(ownerAddress);
		saiMessOwner.setGender(Gender.MALE);

		Address vendorAddress = new Address();
		vendorAddress.setCity("pune");

		saiMess.setVendorddress(vendorAddress);
		saiMess.setOwner(saiMessOwner);
		return saiMess;
	}

	@Test
	public void testCRUDOperations() {
		mess = createSaiVendor();
		generatedMessId = dao.create(mess);
		mess.setId(generatedMessId);
		assertEquals(mess, dao.read(generatedMessId));

		mess.setName("Sai Mess Services");
		dao.update(mess);
		assertEquals(mess, dao.read(generatedMessId));

		dao.delete(mess);
		assertEquals(null, dao.read(generatedMessId));

	}
}
