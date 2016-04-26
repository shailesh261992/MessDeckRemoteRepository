package sampletest.testoval;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import static org.junit.Assert.*;

public class TestConstraintDorClassFields {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Validator validator = new Validator();

		BusinessObject bo = new BusinessObject("a@gmail.com","a@gmail.com","c@gmail.com");

		List<ConstraintViolation> violations = validator.validate(bo);
		
		for (int i = 0; i < violations.size(); i++) {
			System.out.println(violations.get(i));
		}
		
		
		
       
		

	}

}
