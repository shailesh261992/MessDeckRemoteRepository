package com.app.messdeck.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataIntegrityViolationException;

import com.app.messdeck.entity.Vendor;
import com.app.messdeck.model.dto.VendorDTO;
import com.app.messdeck.repository.VendorDAO;
import com.app.messdeck.testData.VendorDTODataSample;

public class TestVendorServiceImpl {

	@Mock
	VendorDAO dao;

	@InjectMocks
	VendorServiceImpl service = new VendorServiceImpl();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testVendorCreate() {

		when(dao.create(any(Vendor.class))).thenReturn(1l);
		Long vendorID = service.createVendor(VendorDTODataSample.getVendorDTO());
		assertEquals(1l, (long) vendorID);
		ArgumentCaptor<Vendor> captor = ArgumentCaptor.forClass(Vendor.class);
		verify(dao).create(captor.capture());
		assertEquals(VendorDTODataSample.getEquivalentVendor(), captor.getValue());

	}

	@Test(expected = DataIntegrityViolationException.class)
	public void testVendorCreateWithIncorrectData() {

		when(dao.create(any(Vendor.class))).thenThrow(new DataIntegrityViolationException(""));
		service.createVendor(VendorDTODataSample.getVendorDTO());

	}

	@Test
	public void testGetVendorSummary() {
		Vendor vendor = VendorDTODataSample.getEquivalentVendor();
		vendor.setId(1);
		when(dao.get(1)).thenReturn(vendor);
		VendorDTO dto = service.getVendorSummary(1l);
		assertEquals(1, dto.getId());
		assertNull(dto.getOwner());
		assertNotNull(dto.getVendorAddress());

	}

	@Test
	public void testGetVendorDetails() {
		Vendor vendor = VendorDTODataSample.getEquivalentVendor();
		vendor.setId(1);
		when(dao.get(1)).thenReturn(vendor);
		VendorDTO dto = service.getVendorDetails(1l);
		assertEquals(1, dto.getId());
		assertNotNull(dto.getOwner());
		assertNotNull(dto.getVendorAddress());

	}

	@Test
	public void testVendorDelete() {
		Vendor vendor = VendorDTODataSample.getEquivalentVendor();
		vendor.setId(1);
		when(dao.get(1)).thenReturn(vendor);
		doNothing().when(dao).delete(vendor);
		service.deleteVendor(1l);

		verify(dao).delete(vendor);
		verify(dao).get(1l);

	}

}
