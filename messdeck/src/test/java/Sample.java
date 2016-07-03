import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

public class Sample {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void whenSerializingJava8Date_thenCorrect() throws IOException {
		LocalDateTime date = LocalDateTime.now();

		// System.out.println(LocalTime.now() < LocalTime);
	}

	@Test

	public void test_arrayContaining_items() throws Exception {

		// Given

		String[] strings = { "why", "hello" };

		// Then

		assertThat(strings, is(arrayContaining("why", "hello")));

	}

}
