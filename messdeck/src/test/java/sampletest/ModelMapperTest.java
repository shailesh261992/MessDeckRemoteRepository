package sampletest;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.spi.Mapping;

import com.app.messdeck.entity.Vendor;
import com.app.messdeck.model.dto.VendorDTO;
import com.app.messdeck.testData.VendorDTODataSample;

public class ModelMapperTest {

	ModelMapper modelMapper;

	{

		modelMapper = new ModelMapper();

		PropertyMap<Vendor, VendorDTO> vendorSummary = new PropertyMap<Vendor, VendorDTO>() {

			@Override
			protected void configure() {
				skip().setOwner(null);
				

			}

		};

		PropertyMap<Vendor, VendorDTO> vendorDetails = new PropertyMap<Vendor, VendorDTO>() {

			@Override
			protected void configure() {

			}
		};

//		modelMapper.addMappings(vendorDetails);
//		modelMapper.addMappings(vendorSummary);

		modelMapper.createTypeMap(Vendor.class, VendorDTO.class, "vendorSummary");
		TypeMap<Vendor, VendorDTO> typeMap = modelMapper.getTypeMap(Vendor.class, VendorDTO.class, "vendorSummary");
		typeMap.addMappings(vendorSummary);
		
		
		System.out.println("typemap = " + typeMap);
		
		
		
		//mappings.add(vendorSummary);

		// modelMapper.createTypeMap(Vendor.class, VendorDTO.class,
		// "vendorDetails");
		// modelMapper.getTypeMap(Vendor.class, VendorDTO.class,
		// "vendorDetails").addMappings(vendorDetails);

		// modelMapper.createTypeMap(Vendor.class,VendorDTO.class,"vendorDetails");

	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		VendorDTO vendor = modelMapper.map(VendorDTODataSample.getEquivalentVendor(), VendorDTO.class,"vendorSummary");

		modelMapper.validate();
		// mapper.ma
		System.out.println(vendor);
	}

}
