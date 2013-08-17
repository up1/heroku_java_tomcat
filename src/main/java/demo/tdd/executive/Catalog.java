package demo.tdd.executive;

import java.util.HashMap;

public class Catalog {
	
	private HashMap<String, String> dataMap = new HashMap<String, String>();
	
	public Catalog(HashMap<String, String> dataMap) {
		this.dataMap = dataMap;
	}

	public String search(String barcode) {
		return dataMap.get(barcode);
	}

}
