package webservices;

import java.util.Map;
import bean.BookBean;
import model.Model;

/*
 * Web Service created using Eclipse Java EE and Apache Axis
 */
public class SOAP_TVS {
	private Model sis;
	private Map<String, BookBean> catalog;
	
	public SOAP_TVS() throws Exception {
    	try {
			this.sis = new Model();
			catalog = sis.retrieveBookByCategory("All");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param productId
	 * @return The book information based on the bookId (ex. "b001")
	 */
	public String getProductInfo(String productId) {
		BookBean bean = catalog.get(productId);
		return "Title: " + bean.getTitle() + System.lineSeparator()
				+ "Author: " + bean.getAuthor() + System.lineSeparator()
				+ "Publisher: " + bean.getPublisher() + System.lineSeparator()
				+ "Cover Art Link: " + bean.getCoverart() + System.lineSeparator()
				+ "Price: " + bean.getPrice() + System.lineSeparator()
				+ "Category: " + bean.getCategory() + System.lineSeparator()
				+ "Description: " + bean.getDescription() + System.lineSeparator();
	}
}
