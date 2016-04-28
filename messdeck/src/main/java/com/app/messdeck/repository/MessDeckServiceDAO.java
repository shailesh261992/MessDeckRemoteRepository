package com.app.messdeck.repository;

import com.app.messdeck.entity.MessDeckService;

public interface MessDeckServiceDAO {

	Long saveMessDeckService(MessDeckService messDeckService);

	void update(MessDeckService messDeckService);

	MessDeckService getMessDeckService(Long id);

	void delete(MessDeckService messDeckService);

}
