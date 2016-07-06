package com.app.messdeck.modelmapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Test;

import com.app.messdeck.abstracttest.AbstractUnitTest;
import com.app.messdeck.entity.MessDeckServiceInfo;
import com.app.messdeck.test.data.MessDeckServiceInfoDataSample;

public class UnitTestDTOConverter extends AbstractUnitTest {

	@Test
	public void testMessDeckServiceInfoDTOConversion() {

		MessDeckServiceInfo messDeckServiceInfo = DTOConverter
				.getMessDeckServiceInfo(MessDeckServiceInfoDataSample.getMessDeckServiceInfoDTO());

		assertThat(messDeckServiceInfo, is(notNullValue()));
		assertThat(messDeckServiceInfo.getVendor(), is(notNullValue()));
		assertThat(messDeckServiceInfo.getVendor().getId(), is(1l));
		assertThat(messDeckServiceInfo.getMeal(), is(notNullValue()));
		assertThat(messDeckServiceInfo.getMeal().get(0).getId(), equalTo(0l));
	}

}
