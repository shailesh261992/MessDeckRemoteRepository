package com.app.messdeck.model.dto;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class TimeDeserializer extends JsonDeserializer<Date> {

	@Override
	public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException, JsonProcessingException {

		String text = jsonParser.getText();
		StringTokenizer stringTokenizer = new StringTokenizer(text, ":");
		String[] a = new String[3];
		int i = 0;
		if (stringTokenizer.countTokens() != 3) {
			throw new JsonProcessingException("Bad Request") {

				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
			};

		}

		while (stringTokenizer.hasMoreElements()) {
			a[i] = stringTokenizer.nextToken();
			i++;
		}

		Calendar c = Calendar.getInstance();
		try {
			c.set(Calendar.HOUR_OF_DAY, Integer.parseInt(a[0]));
			c.set(Calendar.MINUTE, Integer.parseInt(a[1]));
			c.set(Calendar.SECOND, Integer.parseInt(a[2]));
		} catch (NumberFormatException ne) {
			throw new JsonProcessingException("Bad Request") {

				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
			};
		}
		Date startDate = c.getTime();
		return startDate;
	}

}
