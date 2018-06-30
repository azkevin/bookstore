package webservices;

import java.util.HashMap;

/*
 * Web Service created using Eclipse Java EE and Apache Axis
 */
public class SOAP_TVS {
	HashMap<String, String> catalog;
	
	public SOAP_TVS() {
		catalog = new HashMap<String, String>();
		catalog.put("b001", "$10.0");
		catalog.put("b002", "$5.0");
	}
	/**
	 * 
	 * @param productId
	 * @return The book information based on the bookId (ex. "b001")
	 */
	public String getProductInfo(String productId) {
		return (String) catalog.get(productId);
	}
}
