package com.app.messdeck.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.messdeck.model.dto.VendorDTO;
import com.app.messdeck.service.VendorService;

import net.sf.oval.configuration.annotation.IsInvariant;
import net.sf.oval.constraint.AssertValid;

//@Controller
@RestController
@RequestMapping("/vendors")
public class VendorController {

	@Autowired
	private VendorService service;

	public VendorController() {

	}
	
	

	@RequestMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
	public Resource<VendorDTO> getVendorSummary(@PathVariable Long id) {

		VendorDTO vendorSummaryDTO = service.getVendorSummary(id);
		Resource<VendorDTO> resource = new Resource<>(vendorSummaryDTO);
		resource.add(linkTo(methodOn(VendorController.class).getVendorSummary(id)).withSelfRel());

		return resource;

	}

	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createVendor(@Valid @RequestBody VendorDTO dto, HttpServletRequest request) {
		Long vendorID = service.createVendor(dto);
		String resourceUrl = request.getRequestURL().toString() + "/" + vendorID;
		ResponseEntity<?> responseEntity = new ResponseEntity<String>(resourceUrl, HttpStatus.CREATED);
		return responseEntity;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateVendor(@RequestBody VendorDTO dto) {
		service.updateVendor(dto);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteVendor(@PathVariable long id) {
		service.deleteVendor(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);

	}

}
