package com.app.messdeck.customvalidations;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import net.sf.oval.constraint.CheckWithCheck;

public class IsValidMessDeckServiceDate implements CheckWithCheck.SimpleCheck {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(IsValidMessDeckServiceDate.class);

	@Override
	public boolean isSatisfied(Object validatedObject, Object value) {
		Date date = (Date) value;
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date currentDate = calendar.getTime();

		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));

		Date thresholdDate = calendar.getTime();
		logger.debug("Valid Date Range - ");
		logger.debug("Start Date : " + currentDate);
		logger.debug("End date : " + thresholdDate);

		if (date.compareTo(currentDate) < 0 || date.compareTo(thresholdDate) > 0) {
			return false;
		} else {
			return true;
		}

	}

}
