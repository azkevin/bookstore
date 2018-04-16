package model;

import java.util.Map;

import DAO.BookDAO;
import DAO.ReviewDAO;
import bean.BookBean;
import bean.ReviewBean;

public class Model {
	private BookDAO bookDAO;
	private ReviewDAO reviewDAO;
	
	public Model() throws ClassNotFoundException {
		this.bookDAO = new BookDAO();
		this.reviewDAO = new ReviewDAO();
	}
	
	public Map<String, BookBean> retrieveBookByCategory(String category) throws Exception {
		if(category.equalsIgnoreCase("All")) {
			return this.bookDAO.retrieveAll();
		}
		return this.bookDAO.retrieveAllByCategory(category);
	}
	
	public Map<String, BookBean> retrieveBookByBID(String bid) throws Exception {
		return this.bookDAO.retrieveByBID(bid);
	}
	
	public Map<String, ReviewBean> retrieveReviewByBID(String bid) throws Exception {
		return this.reviewDAO.retrieveByBID(bid);
	}
}
