package demo.tdd.executive;

public class Sale {

	private Display display;
	private Catalog catalog;

	public Sale(Display display, Catalog catalog) {
		this.display = display;
		this.catalog = catalog;
	}

	public void seachByBarcode(String barcode) {
		String price = catalog.search( barcode );
		if ( price != null) {
			display.setText("Found product with price = " + price);
		} else {
			display.setText("Not Found product");
		}
	}

}
