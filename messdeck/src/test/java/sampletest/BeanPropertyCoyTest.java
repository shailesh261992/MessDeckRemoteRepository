package sampletest;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import com.app.messdeck.entity.Vendor;
import com.app.messdeck.model.dto.VendorDTO;
import com.app.messdeck.testData.SampleVendorData;

public class BeanPropertyCoyTest {

	@Test
	@Ignore
	public void test() {
		Vendor vendorOne = SampleVendorData.getVendorOne();
		VendorDTO vendorDTO = new VendorDTO();

		BeanUtils.copyProperties(vendorOne, vendorDTO, "vendorddress");

		System.out.println(vendorDTO);
	}

	@Test
	public void test2() {
		AddressDTO addressDTO = new AddressDTO();
		Address address = new Address("10 Silver street", "NYC", "USA");
		BeanUtils.copyProperties(address, addressDTO);
		System.out.println("Address DTO = " + address);
	}

}
