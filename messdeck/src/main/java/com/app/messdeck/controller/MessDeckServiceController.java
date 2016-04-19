package com.app.messdeck.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.messdeck.model.dto.VendorDTO;

/**
 * @author viramgan
 *
 */
@RestController
@RequestMapping("/MessDeckService")
public class MessDeckServiceController {

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createMessDeckService(@RequestBody VendorDTO dto, HttpServletRequest request) {

		return null;
	}

}
