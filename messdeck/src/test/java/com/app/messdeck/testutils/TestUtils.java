package com.app.messdeck.testutils;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.springframework.http.MediaType;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtils {

	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype());

	public static String convertObjectToJsonString(Object object) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		return mapper.writeValueAsString(object);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object convertJsonToObject(String content, Class clazz)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();

		return mapper.readValue(content, clazz);
	}

	public static Date getTime(int hours, int miniutes, int seconds) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, hours);
		calendar.set(Calendar.MINUTE, miniutes);
		calendar.set(Calendar.SECOND, seconds);
		return calendar.getTime();
	}

}
