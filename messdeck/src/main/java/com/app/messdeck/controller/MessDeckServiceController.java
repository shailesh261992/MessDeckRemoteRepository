package com.app.messdeck.controller;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.messdeck.model.dto.MessDeckServiceInfoDTO;
import com.app.messdeck.service.MessDeckService;

/**
 * @author viramgan
 *
 */
@RestController
@RequestMapping("/MessDeckService")
public class MessDeckServiceController {

	@Autowired
	MessDeckService messDeckService;

	@Transactional
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createMessDeckService(@RequestBody MessDeckServiceInfoDTO messDeckServiceDTO,
			HttpServletRequest request) {
		Long id = messDeckService.createMessDeckService(messDeckServiceDTO);
		String resourceUrl = request.getRequestURL().toString() + "/" + id;
		ResponseEntity<?> responseEntity = new ResponseEntity<String>(resourceUrl, HttpStatus.CREATED);
		return responseEntity;

	}

	@RequestMapping("/{id}")
	public MessDeckServiceInfoDTO getMessDeckService(@PathVariable Long id) {
		return messDeckService.getMessDeckService(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateMessDeckService(@RequestBody MessDeckServiceInfoDTO messDeckServiceDTO) {
		messDeckService.updateMessDeckService(messDeckServiceDTO);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteMessDeckService(@PathVariable long id) {
		messDeckService.deleteMessDeckService(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);

	}

}
