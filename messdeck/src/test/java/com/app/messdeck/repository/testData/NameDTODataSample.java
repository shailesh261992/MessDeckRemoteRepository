package com.app.messdeck.repository.testData;

import com.app.messdeck.model.dto.NameDTO;

public class NameDTODataSample {

	public static NameDTO getNameDTO() {
		NameDTO nameDTO = new NameDTO();
		nameDTO.setFirstName("Shailesh");
		nameDTO.setLastName("Kadam");

		return nameDTO;
	}

}
