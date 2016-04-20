package com.app.messdeck.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.messdeck.model.dto.VendorDTO;
import com.app.messdeck.service.VendorService;

@RestController
@RequestMapping("/vendors")
public class VendorController {

	@Autowired
	private VendorService service;

	public VendorController() {

	}

	@RequestMapping("/{id}")
	public VendorDTO getVendor(@PathVariable Long id) {
		return service.getVendor(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createVendor(@RequestBody VendorDTO dto, HttpServletRequest request) {
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
