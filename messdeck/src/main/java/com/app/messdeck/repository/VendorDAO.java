package com.app.messdeck.repository;

import java.util.List;

import com.app.messdeck.entity.Vendor;

public interface VendorDAO {

	Long create(Vendor obj);

	void delete(Vendor obj);

	void update(Vendor vendor);

	Vendor get(long id);

	List<Vendor> getAll();

}
