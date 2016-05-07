package sampletest.testoval;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.app.messdeck.configuration.MessDeckConfiguration;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MessDeckConfiguration.class })
@WebAppConfiguration
public class TestConstraintDorClassFields {
	@Autowired
	Example example;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
       
       example.methodA(new BusinessObject(null, null, null));
       example.methodA(new BusinessObject(null, null, null));
	}

}