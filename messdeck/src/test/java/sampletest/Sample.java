package sampletest;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class Sample {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MONTH, 11);

		int lastDate = calendar.getActualMaximum(Calendar.DATE);
		System.out.println(calendar.getTime());
		System.out.println("Last date =  " + lastDate);

		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 2);

		System.out.println(calendar.getTime());
		lastDate = calendar.getActualMaximum(Calendar.DATE);
		System.out.println("Last date =  " + lastDate);

	}

}
