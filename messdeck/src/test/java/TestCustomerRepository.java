import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.messdeck.abstracttest.AbstractIntegrationTest;
import com.app.messdeck.repository.CustomerRepository;
import com.github.springtestdbunit.annotation.DatabaseSetup;

public class TestCustomerRepository extends AbstractIntegrationTest {

	@Autowired
	private CustomerRepository repository;

	@Test
	@DatabaseSetup(value = { "/dbunit/OwnersAddressData.xml", "/dbunit/OwnersData.xml", "/dbunit/VendorsAddress.xml",
			"/dbunit/VendorsData.xml","/dbunit/CustomersAddress.xml","/dbunit/CustomersData.xml" })

	public void test() {
		System.out.println("Total records = " + repository.count());
		repository.findAll().stream().forEach(x -> System.out.println("name = " + x.getName()));
	}

}
