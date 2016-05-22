import static org.junit.Assert.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;

public class Sample {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void whenSerializingJava8Date_thenCorrect() throws IOException {
		LocalDateTime date = LocalDateTime.now();

		//System.out.println(LocalTime.now() < LocalTime);
	}

}
