package com.app.messdeck.testData;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

public class IntegrationTestData {

	@Autowired
	HibernateTemplate template;

	private static String INSERT_VENDOR_QUERY = "INSERT INTO vendor VALUES(?,?)";
	private static String INSERT_VENDOR_ADDRESS_QUERY = "INSERT INTO vendoraddress VALUES(?,?,?,?,?,?)";
	private static String INSERT_OWNER_QUERY = "INSERT INTO owner VALUES(?,?,?,?,?,?)";
	private static String INSERT_OWNER_ADDRESS_QUERY = "INSERT INTO owneraddress VALUES(?,?,?,?,?,?)";

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
	}

	private void clearData() {
		SQLQuery query = null;
		SessionFactory sessionFactory = template.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		query = session.createSQLQuery("DELETE FROM vendor");
		query.executeUpdate();

		query = session.createSQLQuery("DELETE FROM vendoraddress");
		query.executeUpdate();

		query = session.createSQLQuery("DELETE FROM owner");
		query.executeUpdate();

		query = session.createSQLQuery("DELETE FROM owneraddress");
		query.executeUpdate();
		transaction.commit();

	}

	private void createDB() {
		SessionFactory sessionFactory = template.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("CREATE DATABASE messdecktestdb");
		query.executeUpdate();
		transaction.commit();

	}

	private void dropDB() {
		SessionFactory sessionFactory = template.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("DROP DATABASE messdecktestdb");
		query.executeUpdate();
		transaction.commit();
	}

	private void addVendors() {

		SessionFactory sessionFactory = template.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(INSERT_VENDOR_QUERY);

		query.setLong(0, 1);
		query.setString(1, "Sai Mess");
		query.executeUpdate();

		query.setLong(0, 2);
		query.setString(1, "Andhra Mess");
		query.executeUpdate();

		query.setLong(0, 3);
		query.setString(1, "Nilu Mess");
		query.executeUpdate();

		transaction.commit();

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
	}
}
