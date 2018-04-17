package model;

import java.util.Map;
import DAO.BookDAO;
import DAO.ReviewDAO;
import DAO.LoginDAO;
import bean.BookBean;
import bean.ReviewBean;
import bean.UserBean;

public class Model {
	private BookDAO bookDAO;
	private ReviewDAO reviewDAO;
	private LoginDAO loginDAO;
	
	public Model() throws ClassNotFoundException {
		this.bookDAO = new BookDAO();
		this.reviewDAO = new ReviewDAO();
		this.loginDAO = new LoginDAO();
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
	
	public UserBean retrieveUser(String username, String password) throws Exception {
		return this.loginDAO.loginUser(username, password);
	}
	
}
