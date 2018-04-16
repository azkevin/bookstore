package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Model;

/**
 * Servlet implementation class Start
 */
@WebServlet(urlPatterns = {"/Start"})
public class Start extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Model sis;
       
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
		String category = request.getParameter("category");
		String book = request.getParameter("book");
		
		request.setAttribute("category", category); //Set attribute for header on main page
		
		//<TODO> error checking on all control flow
		// User selects a book category to browse
		if(category != null && !category.equals("")){
			try {
				request.setAttribute("books", sis.retrieveBookByCategory(category));
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher(target).forward(request, response);
		} 
		// User selects a book for more details
		else if(book != null && !book.equals("")) {
			target = "Book.jspx";
			try {
				request.setAttribute("book", sis.retrieveBookByBID(book));
				request.setAttribute("review", sis.retrieveReviewByBID(book));
			} catch (Exception e) {
				e.printStackTrace();
			}
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
