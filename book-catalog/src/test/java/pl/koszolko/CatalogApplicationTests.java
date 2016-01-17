package pl.koszolko;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.koszolko.book.catalog.CatalogApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CatalogApplication.class)
@WebAppConfiguration
public class CatalogApplicationTests {

	@Test
	public void contextLoads() {
	}

}
