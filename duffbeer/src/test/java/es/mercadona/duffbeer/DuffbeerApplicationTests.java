package es.mercadona.duffbeer;

import es.mercadona.duffbeer.web.ProductosWebController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DuffbeerApplicationTests {

	@Autowired
	private ProductosWebController controller;

	@Test
	void contextLoads() {
		Assertions.assertThat(controller).isNotNull();
	}

}
