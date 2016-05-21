package com.app.messdeck.repository;

import com.app.messdeck.entity.MessDeckServiceInfo;

public interface MessDeckServiceInfoDAO {

	Long create(MessDeckServiceInfo messDeckService);

	void update(MessDeckServiceInfo messDeckService);

	MessDeckServiceInfo get(Long id);

	void delete(Long id);

}
