package net.balgre.network;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import net.balgre.domain.MainResponse;
import net.balgre.domain.Product;

/**
 * Unit test for simple App.
 */
public class BalgreRestTest {
	
	BalgreClient client;
	
	@Before
	public void setup() {
		client = new BalgreClient();
	}
	
	@Test
	public void getMain() {
		MainResponse response = client.getMain();
		assertNotNull(response);
		assertNotNull(response.getMessage());
	}
	
	@Test
	public void getProductDetail() {
		Long productId = 1L;
		Product response = client.getProductDetail(productId);
		assertNotNull(response);
	}
	
}
