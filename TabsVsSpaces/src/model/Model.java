package model;

import java.util.Map;

import DAO.BookDAO;
import bean.BookBean;

public class Model {
	private BookDAO bookDAO;
	
	public Model() throws ClassNotFoundException {
		this.bookDAO = new BookDAO();
	}
	
	public Map<String, BookBean> retrieveByCategory(String category) throws Exception {
		if(category.equalsIgnoreCase("All")) {
			return this.bookDAO.retrieveAll();
		}
		return this.bookDAO.retrieveAllByCategory(category);
	}
}
