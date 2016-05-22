package com.app.messdeck.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.messdeck.annotations.Loggable;
import com.app.messdeck.model.dto.MessDeckServiceInfoDTO;
import com.app.messdeck.service.MessDeckService;

@RestController
@RequestMapping("/messdeckservice")
public class MessDeckServiceController {

	@Autowired
	MessDeckService messDeckService;

	@Loggable
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource<?> createMessDeckService(@RequestBody MessDeckServiceInfoDTO messDeckServiceDTO,
			HttpServletRequest request) {
		Long id = messDeckService.createMessDeckService(messDeckServiceDTO);
		MessDeckServiceInfoDTO fetchedMessDeckService = messDeckService.getMessDeckService(id);
		Resource<MessDeckServiceInfoDTO> resource = new Resource<MessDeckServiceInfoDTO>(fetchedMessDeckService);
		resource.add(linkTo(methodOn(MessDeckServiceController.class).getMessDeckService(id)).withSelfRel());
		return resource;
	}

	@Loggable
	@RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public MessDeckServiceInfoDTO getMessDeckService(@PathVariable Long id) {
		return messDeckService.getMessDeckService(id);
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateMessDeckService(@RequestBody MessDeckServiceInfoDTO messDeckServiceDTO) {
		long id = messDeckServiceDTO.getId();
		messDeckService.updateMessDeckService(messDeckServiceDTO);
		MessDeckServiceInfoDTO fetchedMessDeckService = messDeckService.getMessDeckService(id);
		Resource<MessDeckServiceInfoDTO> resource = new Resource<MessDeckServiceInfoDTO>(fetchedMessDeckService);
		resource.add(linkTo(methodOn(MessDeckServiceController.class).getMessDeckService(id)).withSelfRel());
		return new ResponseEntity<Object>(resource, HttpStatus.OK);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteMessDeckService(@PathVariable long id) {
		messDeckService.deleteMessDeckService(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);

	}

}
