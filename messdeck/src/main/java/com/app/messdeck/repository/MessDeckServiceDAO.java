package com.app.messdeck.repository;

import com.app.messdeck.entity.MessDeckService;

public interface MessDeckServiceDAO {

	Long create(MessDeckService messDeckService);

	void update(MessDeckService messDeckService);

	MessDeckService get(Long id);

	void delete(Long id);

}
