package controller;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AddressBean;
import bean.BookBean;
import bean.CartBean;
import bean.CreditCardBean;
import bean.ReviewBean;
import bean.SoldBean;
import bean.UserBean;
import model.CartUtil;
import model.Model;
import model.ReviewUtil;
import webservices.SOAPUtils;

/**
 * Servlet implementation class Start
 */
@WebServlet(urlPatterns = {"/Start", "/LoginPage", "/RegisterUserPage", "/VerifyOrderPage"})
public class Start extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Model sis;
	private UserBean currentUser;
	private AddressBean currentUserAddress;
	private CreditCardBean currentUserCreditCard;
	private Map<String, SoldBean> booksSold;
	
	//used for login
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	
	//used for account creation
	private static final String ACC_EMAIL = "email";
	private static final String ACC_PASSWORD = "acc_password";
	private static final String ACC_C_PASSWORD = "acc_c_password";
	private static final String ACC_FNAME = "firstname";
	private static final String ACC_LNAME = "lastname";
	private static final String ACC_STREET = "streetname";
	private static final String ACC_PROVINCE = "province";
	private static final String ACC_COUNTRY = "country";
	private static final String ACC_ZIP = "zip";
	private static final String ACC_PHONE = "phone";
	private static final String ACC_CARD_TYPE = "card_type";
	private static final String ACC_CARD = "card_num";
	private static final String ACC_CVV = "cvv";
	private static final String ACC_MONTH = "month";
	private static final String ACC_YEAR = "year";
	
	//used for admin analytics
	private static final String ADMIN_MONTH = "admin-month";
	private static final String ADMIN_YEAR = "admin-year";
	
	//Used for reviews
	private static final String REVIEW_BID = "reviewBookId";
	private static final String REVIEW_TEXT = "reviewText";
	private static final String REVIEW_RATING = "reviewRating";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Start() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException{
    	try {
			this.sis = new Model();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/plain");
		
		String target = "MainPage.jspx";
		
		// Book Details pages
		String category = request.getParameter("category");
		String book = request.getParameter("book");
		String getProductInfo = request.getParameter("getProductInfo");
		
		// Shopping Cart pages
		String cartPage = request.getParameter("cartPage");
		String cartRemove = request.getParameter("cartRemove");
		String addToCart = request.getParameter("addToCart");
		
		// Login/Logout pages
		String username = request.getParameter(USERNAME);
		String password = request.getParameter(PASSWORD);
		String email = request.getParameter(ACC_EMAIL);
		String acc_password = request.getParameter(ACC_PASSWORD);
		String acc_c_password = request.getParameter(ACC_C_PASSWORD);
		String fName = request.getParameter(ACC_FNAME);
		String lName = request.getParameter(ACC_LNAME);
		String street = request.getParameter(ACC_STREET);
		String province = request.getParameter(ACC_PROVINCE);
		String country = request.getParameter(ACC_COUNTRY);
		String zip = request.getParameter(ACC_ZIP);
		String phoneNumber = request.getParameter(ACC_PHONE);
		String cardtype = request.getParameter(ACC_CARD_TYPE);
		String cardnum = request.getParameter(ACC_CARD);
		String cvv = request.getParameter(ACC_CVV);
		String month = request.getParameter(ACC_MONTH);
		String year = request.getParameter(ACC_YEAR);
		
		//Review pages
		String reviewBookId = request.getParameter(REVIEW_BID);
		String reviewRating = request.getParameter(REVIEW_RATING);
		String reviewText = request.getParameter(REVIEW_TEXT);
		
		request.setAttribute("category", category); //Set attribute for header on main page
				
		//If the login button is clicked
		if(request.getParameter("login") != null)
		{
			//currentUser = null;
			try {
				currentUser = sis.retrieveUser(username, password);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				currentUserAddress = sis.getAddress(currentUser.getUserID());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				currentUserCreditCard = sis.getCreditCard(currentUser.getUserID());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(currentUser != null)
			{
				//Login Successful. Load main page
				request.getServletContext().setAttribute("username", currentUser);
				request.getServletContext().setAttribute("userdetails", currentUserAddress);
				request.getServletContext().setAttribute("usercreditcard", currentUserCreditCard);
				
				//if the current user is admin, take him to AdminPage
				if(currentUser.getFirstName().equals("admin"))
				{
					try {
						booksSold = sis.retrieveBooksSold();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if(booksSold != null)
					{
						request.getServletContext().setAttribute("booksSold", booksSold);
					}
					
					request.getRequestDispatcher("AdminPage.jspx").forward(request, response);
				}
				else 
				{
					String url = request.getRequestURL().append("?").append("category=All").toString();
					response.sendRedirect(url);
				}
			}
			else {
				//Failed Login. Re-load loginPage
				request.setAttribute("error", "Invalid username or password.");
				request.getRequestDispatcher("LoginPage.jspx").forward(request, response);
			}
		}
		
		//If the logout button is clicked
		else if(request.getParameter("logout") != null)
		{
			//remove attribute from servlet context
			//yet to implement error logging out case(not necessary though)
			currentUser = null;
			currentUserAddress = null;
			currentUserCreditCard = null;
			username = "";
			password = "";
			request.getServletContext().removeAttribute("username");
			request.getServletContext().removeAttribute("userdetails");
			request.getServletContext().removeAttribute("usercreditcard");
			
			if(request.getServletContext().getAttribute("username") == null)
			{
				String url = request.getRequestURL().append("?").append("category=All").toString();
				response.sendRedirect(url);
			}
			else {
				request.setAttribute("error", "Error logging out.");
				request.getRequestDispatcher("MainPage.jspx").forward(request, response);
			}
		}
		
		//if the user is creating an account
		else if (request.getParameter("register") != null)
		{
			String user_name = email.substring(0, email.indexOf('@'));
			try {
				currentUser = sis.addNewUser(user_name, acc_password, email, fName, lName, street, province, country, zip, phoneNumber, cardtype, cardnum, cvv, month, year);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				currentUserAddress = sis.getAddress(currentUser.getUserID());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				currentUserCreditCard = sis.getCreditCard(currentUser.getUserID());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(currentUser != null)
			{
				//Account Creation Successful. Load main page
				request.getServletContext().setAttribute("username", currentUser);
				request.getServletContext().setAttribute("userdetails", currentUserAddress);
				request.getServletContext().setAttribute("usercreditcard", currentUserCreditCard);
				String url = request.getRequestURL().append("?").append("category=All").toString();
				response.sendRedirect(url);
			}
			else {
				//Failed Login. Re-load loginPage
				request.setAttribute("error", "Account Creation Failed!");
				request.getRequestDispatcher("RegisterUserPage.jspx").forward(request, response);
			}
		}
			
		// User checks the cart
		else if (currentUser != null && cartPage != null && !cartPage.equals("")) {
			target = "CartPage.jspx";
			try {
				// Show items in cart
				Map<Integer, CartBean> cart = sis.retrieveCartByUserId(currentUser.getUserID());
				request.setAttribute("cart", cart);
				request.setAttribute("cartSize", cart.size());
				request.setAttribute("cartPrice", CartUtil.calculateTotalPrice(cart));

			} catch (Exception e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher(target).forward(request, response);
		}
		// User removes item in cart
		else if (currentUser != null && cartRemove != null && !cartRemove.equals("")) {
			target = "/?cartPage=cartPage";
			try {
				// Remove cart item
				sis.removeCartByCartId(Integer.parseInt(cartRemove));
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher(target).forward(request, response);
		}
		
		else if(request.getParameter("confirm") != null) 
		{
			//place an order
			
			//<TODO> Code to submit an order, depends on how the shopping cart is defined
			
		}
		
		else if(category != null && !category.equals("")){
			try {
				request.setAttribute("books", sis.retrieveBookByCategory(category));
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher(target).forward(request, response);
		} 
		// User has submitted a review
		else if((reviewRating != null && reviewText != null && reviewBookId != null)
				&& (!reviewRating.equals("") && !reviewText.equals("") && !reviewBookId.equals(""))) {
			try {
				// Add the review to db
				this.sis.addNewReview(reviewBookId, 
						this.currentUser.getUserID(), 
						this.currentUser.getUserName(), 
						Integer.parseInt(reviewRating), 
						reviewText);
				
				// Redirect back to the book page
				String url = request.getRequestURL().append("?").append("book=").append(reviewBookId).toString();
				response.sendRedirect(url);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// User selects a book for more details
		else if(book != null && !book.equals("")) {
			target = "Book.jspx";
			try {
				// Show latest reviews first
				Map<Integer, ReviewBean> bookReviews = new TreeMap<Integer, ReviewBean>(Collections.reverseOrder());
				bookReviews.putAll(sis.retrieveReviewByBID(book));
				request.setAttribute("book", sis.retrieveBookByBID(book));
				request.setAttribute("review", bookReviews);
				request.setAttribute("reviewAvg", ReviewUtil.calculateAvgBookRating(bookReviews));
				
				// If the user has signed in, then give them an option to add a review
				if(!(this.currentUser == null)) {
					request.setAttribute("reviewEligible", true);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher(target).forward(request, response);
		}		
		
		// Book is added to the cart
		else if (currentUser != null && addToCart != null && !addToCart.equals(""))
		{
			try {
				sis.addToCart(currentUser.getUserID(), addToCart);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// Redirect back to the book page
			String url = request.getRequestURL().append("?").append("book=").append(addToCart).toString();
			response.sendRedirect(url);
		}
		
		// User uses SOAP service "getProductInfo(bid)"
		else if(getProductInfo != null && !getProductInfo.equals("")) {
			target = "getProductInfo.jspx";
			SOAPUtils util = new SOAPUtils();
			request.setAttribute("getProductInfo", util.getProductInfo(getProductInfo));
			request.getRequestDispatcher(target).forward(request, response);
		}
		//Default category should be "All" on the landing page
		else {
			String url = request.getRequestURL().append("?").append("category=All").toString();
			response.sendRedirect(url);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
	}

}
