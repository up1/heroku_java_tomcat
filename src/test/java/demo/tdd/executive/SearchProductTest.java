package demo.tdd.executive;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

public class SearchProductTest {

	@Test
	public void searchProductFound() throws Exception {
		Display display = new Display();
		Catalog catalog = new Catalog(new HashMap<String, String>() {
			{
				put("1234", "100");
				put("123", "200");
			}
		});
		Sale sale = new Sale(display, catalog);
		sale.seachByBarcode("1234");
		assertEquals("Found product with price = 100", display.getText());

	}

	@Test
	public void searchProductNotFound() throws Exception {
		Display display = new Display();
		Catalog catalog = new Catalog(new HashMap<String, String>() {
			{
				put("1234", "100");
				put("123", "200");
			}
		});
		Sale sale = new Sale(display, catalog);
		sale.seachByBarcode("1");
		assertEquals("Not Found product", display.getText());

	}
}
