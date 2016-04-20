package com.app.messdeck.repository;

import com.app.messdeck.entity.Vendor;

public interface VendorDAO {

	Long create(Vendor obj);

	void delete(Vendor obj);

	void update(Vendor vendor);

	Vendor read(long id);

}
