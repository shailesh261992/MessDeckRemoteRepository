package com.app.messdeck.repository;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.messdeck.model.Address;
import com.app.messdeck.model.Customer;
import com.app.messdeck.model.EmailID;
import com.app.messdeck.model.Gender;
import com.app.messdeck.model.Name;
import com.app.messdeck.model.Owner;
import com.app.messdeck.model.Vendor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:DefaultServlet-servlet.xml" })
public class TestCustomerDAO {

	//
	// @Autowired
	// private CRUDDAO dao;
	@Autowired
	CustomerDAO cdao;
	@Autowired
	VenderDAO vdao;

	@Test
    @Ignore
	public void test() {

		Vendor v = new Vendor();
		v.setName("Sai Mess");

		Owner o = new Owner();
		o.setName(new Name("Shailesh", "Kadam"));
		o.setEmailID(new EmailID("owner@gmail.com"));

		Address address = new Address();
		address.setCity("pune");
		//v.setAddress(address);
		v.setOwner(o);

		vdao.create(v);

		Customer customer = new Customer();

		customer.setBalanceAmount(1000);
		customer.setCreditAmount(100);
		customer.setName(new Name("Rahul", "Navadkar"));
		customer.setVendor(v);
		customer.setGender(Gender.FEMALE);
		customer.setEmailID(new EmailID("shailesh261992@gmail.com"));
	

		Address a = new Address();
		a.setCity("satara");
		
		customer.setAddress(a);
		
		cdao.create(customer);

		// Item item1 = new Item();
		// Item item2 = new Item();
		//
		// item1.setName("Rajma");
		// item2.setName("Varan");
		//
		// ArrayList<Item> list = new ArrayList<Item>();
		// list.add(item1);
		// list.add(item2);
		//
		// MessDeckService messDeckService = new MessDeckService();
		// messDeckService.setService(ServiceType.DINNER);
		// messDeckService.setCost(100);
		// messDeckService.setDate(new Date());
		// messDeckService.setVendor(v);
		// messDeckService.setMeal(list);
		//
		// MessDeckService messDeckService2 = new MessDeckService();
		// messDeckService2.setService(ServiceType.DINNER);
		// messDeckService2.setCost(100);
		// messDeckService2.setDate(new Date());
		// messDeckService2.setVendor(v);
		// messDeckService2.setMeal(list);

		// dao.create(messDeckService);
		// dao.create(messDeckService2);

	}

	// @Test
	// public void test2() {
	//
	// Vendor v = new Vendor();
	// v.setName("Sai Mess");
	//
	// Owner o = new Owner();
	// o.setName(new Name("Shailesh", "Kadam"));
	//
	// Address address = new Address();
	// address.setCity("pune");
	// v.setAddress(address);
	// v.setOwner(o);
	//
	// dao.create(v);
	//
	// Customer customer = new Customer();
	//
	// customer.setBalanceAmount(1000);
	// customer.setCreditAmount(100);
	// customer.setName(new Name("Rahul", "Navadkar"));
	// customer.setVendor(v);
	// daoC.create(customer);
	// }

}
