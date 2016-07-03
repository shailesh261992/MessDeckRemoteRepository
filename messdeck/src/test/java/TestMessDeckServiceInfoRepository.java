import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import com.app.messdeck.configuration.MessDeckConfiguration;
import com.app.messdeck.repository.VendorRepository;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MessDeckConfiguration.class })
@WebAppConfiguration
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
		DbUnitTestExecutionListener.class, TransactionalTestExecutionListener.class })
public class TestMessDeckServiceInfoRepository {
	@Autowired
	private VendorRepository repo;

	@Test
	@DatabaseSetup(value = "VendorsData.xml")
	public void test() {
		System.out.println("Total records = " + repo.count());
		repo.findAll().stream().forEach(x -> System.out.println("name = " + x.getName()));
	}

}
