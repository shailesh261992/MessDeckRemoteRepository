import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import com.app.messdeck.repository.VendorRepository;
import com.app.messdeck.s2.Application;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class })
@WebAppConfiguration
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
		DbUnitTestExecutionListener.class, TransactionalTestExecutionListener.class })
public class TestVendorRepository {
	@Autowired
	private VendorRepository repo;

	@After
	public void after() {

	}

	@Test
	@DatabaseSetup(value = "VendorsData.xml")
	public void test() {
		System.out.println("Total records = " + repo.count());
		repo.findAll().stream().forEach(x -> System.out.println("name = " + x.getName()));
	}

}
