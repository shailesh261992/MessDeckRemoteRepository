import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.messdeck.abstracttest.AbstractIntegrationTest;
import com.app.messdeck.entity.MessDeckServiceInfo;
import com.app.messdeck.repository.MessDeckServiceInfoRepository;
import com.github.springtestdbunit.annotation.DatabaseSetup;

public class MessDeckServiceInfoRepositoryIntegrationTest extends AbstractIntegrationTest {

	@Autowired
	private MessDeckServiceInfoRepository repository;

	@Test
	@DatabaseSetup(value = { "/dbunit/OwnersAddressData.xml", "/dbunit/OwnersData.xml", "/dbunit/VendorsAddress.xml",
			"/dbunit/VendorsData.xml", "/dbunit/CustomersAddress.xml", "/dbunit/CustomersData.xml",
			"/dbunit/MessDeckServiceInfoData.xml", "/dbunit/CustomersSrvices.xml" })

	@Transactional
	public void test() {
		System.out.println("Total records = " + repository.count());
		MessDeckServiceInfo serviceInfo = repository.findOne(1l);

		serviceInfo.getSubscribers().stream().forEach(x -> System.out.println(x));
	}

}
