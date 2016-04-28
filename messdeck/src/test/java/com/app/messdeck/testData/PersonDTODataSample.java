package com.app.messdeck.testData;

import com.app.messdeck.model.dto.PersonDTO;

public class PersonDTODataSample {

	public static PersonDTO getPersonDTO() {
		PersonDTO personDTO = new PersonDTO();
		personDTO.setMobileNo("7276248187");
		personDTO.setEmailID(EmailIDDTODataSample.getEmailIDDTO());
		personDTO.setName(NameDTODataSample.getNameDTO());
		return personDTO;
	}

}
