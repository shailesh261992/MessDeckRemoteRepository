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

import com.app.messdeck.model.dto.CustomerDTO;
import com.app.messdeck.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@RequestMapping("/{id}")
	public CustomerDTO getCustomer(@PathVariable long id) {
		return service.getCustomer(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createCustomer(@RequestBody CustomerDTO dto, HttpServletRequest request) {
		Long customerID = service.createCustomer(dto);
		String resourceUrl = request.getRequestURL().toString() + "/" + customerID;
		ResponseEntity<?> responseEntity = new ResponseEntity<String>(resourceUrl, HttpStatus.CREATED);
		return responseEntity;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCustomer(@RequestBody CustomerDTO dto) {
		service.updateCustomer(dto);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCustomer(@PathVariable long id) {
		service.deleteCustomer(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);

	}

}
