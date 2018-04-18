package model;

import java.util.ArrayList;
import java.util.Map;

import DAO.AddressDAO;
import DAO.BookDAO;
import DAO.ReviewDAO;
import DAO.LoginDAO;
import DAO.OrderDAO;
import DAO.RegisterDAO;
import bean.AddressBean;
import bean.BookBean;
import bean.ReviewBean;
import bean.UserBean;

public class Model {
	private BookDAO bookDAO;
	private ReviewDAO reviewDAO;
	private LoginDAO loginDAO;
	private RegisterDAO registerDAO;
	private AddressDAO addressDAO;
	private OrderDAO orderDAO;
	
	public Model() throws ClassNotFoundException {
		this.bookDAO = new BookDAO();
		this.reviewDAO = new ReviewDAO();
		this.loginDAO = new LoginDAO();
		this.registerDAO = new RegisterDAO();
		this.addressDAO = new AddressDAO();
		this.orderDAO = new OrderDAO();
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
	
	public UserBean addNewUser(String username, String pwd, String email, String fName, String lName, String street, String province,
			String country, String zip, String phoneNumber) throws Exception {
		return registerDAO.addNewUser(username, pwd, email, fName, lName, street, province, country, zip, phoneNumber);
	}
	
	public AddressBean getAddress(int userID) throws Exception{
		return addressDAO.getAddress(userID);
	}
	
//	public String submitOrder(int uid, String status, ArrayList<CartBean> list) throws Exception{
//		return orderDAO.submitOrder(uid, status, list);
//	}
//	
}
