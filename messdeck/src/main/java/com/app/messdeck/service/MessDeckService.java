package com.app.messdeck.service;

import com.app.messdeck.model.dto.MessDeckServiceInfoDTO;

public interface MessDeckService {

	Long createMessDeckService(MessDeckServiceInfoDTO messDeckServiceDTO);

	MessDeckServiceInfoDTO getMessDeckService(Long id);

	void updateMessDeckService(MessDeckServiceInfoDTO messDeckServiceDTO);

	void deleteMessDeckService(Long id);

}
