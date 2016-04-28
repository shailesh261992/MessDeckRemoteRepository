package com.app.messdeck.service;

import com.app.messdeck.model.dto.MessDeckServiceDTO;

public interface MessDeckService {

	Long saveMessDeckService(MessDeckServiceDTO messDeckServiceDTO);

	MessDeckServiceDTO getMessDeckService(Long id);

	void updateMessDeckService(MessDeckServiceDTO messDeckServiceDTO);

	void deleteMessDeckService(Long id);

}
