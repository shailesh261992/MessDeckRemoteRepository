package com.app.messdeck.test.data;

import java.util.Date;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

public class IntegrationTestData {

	@Autowired
	HibernateTemplate template;

	private static String INSERT_VENDOR_QUERY = "INSERT INTO vendor(id,name,emailId,registrationDate) VALUES(?,?,?,?)";
	private static String INSERT_VENDOR_ADDRESS_QUERY = "INSERT INTO vendoraddress VALUES(?,?,?,?,?,?)";
	private static String INSERT_OWNER_QUERY = "INSERT INTO owner VALUES(?,?,?,?,?,?)";
	private static String INSERT_OWNER_ADDRESS_QUERY = "INSERT INTO owneraddress VALUES(?,?,?,?,?,?)";
	private static String INSERT_CUSTOMER_QUERY = "INSERT INTO customer VALUES(?,?,?,?,?,?,?)";
	private static String INSERT_CUSTOMER_ADDRESS_QUERY = "INSERT INTO customeraddress VALUES(?,?,?,?,?,?)";

	public IntegrationTestData() {

	}

	public IntegrationTestData(HibernateTemplate template) {
		this.template = template;
	}

	public void initializeTestData() {
		clearData();
		addVendors();
		addVendorAddress();
		addOwners();
		addOwnerAddress();
		addCustomers();
		addCustomerAddress();
	}

	private void clearData() {
		SQLQuery query = null;
		SessionFactory sessionFactory = template.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		query = session.createSQLQuery("DELETE FROM customeraddress");
		query.executeUpdate();

		query = session.createSQLQuery("DELETE FROM customer");
		query.executeUpdate();

		query = session.createSQLQuery("DELETE FROM vendor");
		query.executeUpdate();

		query = session.createSQLQuery("DELETE FROM vendoraddress");
		query.executeUpdate();

		query = session.createSQLQuery("DELETE FROM owner");
		query.executeUpdate();

		query = session.createSQLQuery("DELETE FROM owneraddress");
		query.executeUpdate();

		transaction.commit();
		session.close();

	}

	private void addVendors() {

		SessionFactory sessionFactory = template.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(INSERT_VENDOR_QUERY);

		query.setLong(0, 1);
		query.setString(1, "Sai Mess");
		query.setString(2, "sai@gmail.com");
		query.setDate(3, new Date());
		query.executeUpdate();

		query.setLong(0, 2);
		query.setString(1, "Sonu Mess");
		query.setString(2, "Sonu@gmail.com");
		query.setDate(3, new Date());
		query.executeUpdate();

		query.setLong(0, 3);
		query.setString(1, "Nilu Mess");
		query.setString(2, "Nilu@gmail.com");
		query.setDate(3, new Date());
		query.executeUpdate();

		transaction.commit();
		session.close();

	}

	private void addVendorAddress() {
		SessionFactory sessionFactory = template.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(INSERT_VENDOR_ADDRESS_QUERY);
		query.setLong(0, 1);
		query.setString(1, "pune");
		query.setString(2, "India");
		query.setString(3, "410507");
		query.setString(4, "Maharashtra");
		query.setString(5, "Talegaon");
		query.executeUpdate();

		query.setLong(0, 2);
		query.setString(1, "pune");
		query.setString(2, "India");
		query.setString(3, "410508");
		query.setString(4, "Maharashtra");
		query.setString(5, "Shivaji Chowk");
		query.executeUpdate();

		query.setLong(0, 3);
		query.setString(1, "pune");
		query.setString(2, "India");
		query.setString(3, "410509");
		query.setString(4, "Maharashtra");
		query.setString(5, "Station Chowk");
		query.executeUpdate();

		transaction.commit();
		session.close();
	}

	public void addOwners() {
		SessionFactory sessionFactory = template.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(INSERT_OWNER_QUERY);

		query.setLong(0, 1);
		query.setString(1, "sai@gmail.com");
		query.setInteger(2, 1);
		query.setString(3, "7276248187");
		query.setString(4, "Sai");
		query.setString(5, "Prasad");
		query.executeUpdate();

		query.setLong(0, 2);
		query.setString(1, "andhra@gmail.com");
		query.setInteger(2, 1);
		query.setString(3, "9876543210");
		query.setString(4, "Zee");
		query.setString(5, "Khan");
		query.executeUpdate();

		query.setLong(0, 3);
		query.setString(1, "Nilu@gmail.com");
		query.setInteger(2, 1);
		query.setString(3, "7624563456");
		query.setString(4, "Nilu");
		query.setString(5, "Puranik");
		query.executeUpdate();

		transaction.commit();
		session.close();
	}

	public void addOwnerAddress() {
		SessionFactory sessionFactory = template.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(INSERT_OWNER_ADDRESS_QUERY);
		query.setLong(0, 1);
		query.setString(1, "pune");
		query.setString(2, "India");
		query.setString(3, "410507");
		query.setString(4, "Maharashtra");
		query.setString(5, "Talegaon");
		query.executeUpdate();

		query.setLong(0, 2);
		query.setString(1, "pune");
		query.setString(2, "India");
		query.setString(3, "410508");
		query.setString(4, "Maharashtra");
		query.setString(5, "Shivaji Chowk");
		query.executeUpdate();

		query.setLong(0, 3);
		query.setString(1, "pune");
		query.setString(2, "India");
		query.setString(3, "410509");
		query.setString(4, "Maharashtra");
		query.setString(5, "Station Chowk");
		query.executeUpdate();

		transaction.commit();
		session.close();
	}

	public void addCustomers() {

		SessionFactory sessionFactory = template.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(INSERT_CUSTOMER_QUERY);
		query.setLong(0, 1);
		query.setString(1, "ganesh@gmail.com");
		query.setInteger(2, 1);
		query.setString(3, "7770092161");
		query.setString(4, "Ganesh");
		query.setString(5, "Kadam");
		query.setInteger(6, 1);
		query.executeUpdate();
		session.flush();
		session.clear();

		query.setLong(0, 2);
		query.setString(1, "harshad@gmail.com");
		query.setInteger(2, 1);
		query.setString(3, "7779999999");
		query.setString(4, "Harshad");
		query.setString(5, "Thorat");
		query.setInteger(6, 1);
		query.executeUpdate();
		session.flush();
		session.clear();

		query.setLong(0, 3);
		query.setString(1, "Rohit@gmail.com");
		query.setInteger(2, 1);
		query.setString(3, "7878787878");
		query.setString(4, "Rohit");
		query.setString(5, "Navadkar");
		query.setInteger(6, 1);
		query.executeUpdate();

		transaction.commit();
		session.close();

	}

	public void addCustomerAddress() {
		SessionFactory sessionFactory = template.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(INSERT_CUSTOMER_ADDRESS_QUERY);
		query.setLong(0, 1);
		query.setString(1, "pune");
		query.setString(2, "India");
		query.setString(3, "410507");
		query.setString(4, "Maharashtra");
		query.setString(5, "Talegaon street 1");
		query.executeUpdate();

		query.setLong(0, 2);
		query.setString(1, "pune");
		query.setString(2, "India");
		query.setString(3, "410507");
		query.setString(4, "Maharashtra");
		query.setString(5, "Talegaon street 2");
		query.executeUpdate();

		query.setLong(0, 3);
		query.setString(1, "pune");
		query.setString(2, "India");
		query.setString(3, "410507");
		query.setString(4, "Maharashtra");
		query.setString(5, "Talegaon street 3");
		query.executeUpdate();

		transaction.commit();
		session.close();

	}

}
