package com.app.messdeck.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.messdeck.model.Address;
import com.app.messdeck.model.Name;
import com.app.messdeck.model.Owner;
import com.app.messdeck.model.Vendor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:DefaultServlet-servlet.xml" })
public class TestVendorDAO {
	
	@Autowired
	private VenderDAO dao;

	@Test
	public void test() {
		//fail("Not yet implemented");
		Vendor v = new Vendor();
		v.setName("Sai Mess");

		Owner o = new Owner();
		o.setName(new Name("Shailesh", "Kadam"));
		

		Address address = new Address();
		address.setCity("pune");
		v.setAddress(address);
		v.setOwner(o);

		dao.create(v);
		
	}

}
